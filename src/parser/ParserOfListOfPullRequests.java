package parser;

import connection.ConnectionToPRsListAPI;

import server.GitPlatform;
import unit.Repository;
import unit.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import unit.PullRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * In this class we parse data from API gitplatform page with all pull requests
 */
public class ParserOfListOfPullRequests {

    private ConnectionToPRsListAPI connectionToPRsListAPI;
    private String parsedDataFromURLAsString;

    private PullRequest pullRequest;
    private ParserOfOnePullRequest parserOfOnePullRequest;

    public ParserOfListOfPullRequests(){
        parserOfOnePullRequest = new ParserOfOnePullRequest();
    }

    /**
     *
     * @param bitbucket
     * @param repository
     * @param user
     * @throws IOException
     * @throws ParseException
     *
     * Parses json from API bitbucket
     * as parameters we give gitplatform and and objects created in class Main
     * In given Repository we have Arraylist of pullrequests
     * We parse these pull requests and add these to this Arraylist
     * then we call method parseOnePR from class ParserOfOnePullRequest to get data about each pull request in repo
     *
     */
    public void parseListOfPRs(GitPlatform bitbucket, Repository repository, User user) throws IOException, ParseException {
        connectionToPRsListAPI = new ConnectionToPRsListAPI();
        connectionToPRsListAPI.connectWithURL(bitbucket, repository, user);

        if(connectionToPRsListAPI.getResponseCode() == 404)
            System.out.println("ERROR 404 NOT FOUND");
        if(connectionToPRsListAPI.getResponseCode() != 200)
            throw new RuntimeException("HttpResponseCode: " + connectionToPRsListAPI.getResponseCode());
        if(connectionToPRsListAPI.getResponseCode() == 200){
            try {
                BufferedReader bufferedReaderMain = new BufferedReader(new InputStreamReader(connectionToPRsListAPI.getUrl().openStream()));
                JSONParser parserForJsonMain = new JSONParser();
                while (null != (parsedDataFromURLAsString = bufferedReaderMain.readLine())) {
                    JSONObject jsonObjectMain = (JSONObject)parserForJsonMain.parse(parsedDataFromURLAsString);
                    JSONArray jsonArrayMain = (JSONArray)jsonObjectMain.get("values");
                    for (Object obj : jsonArrayMain) {
                        JSONObject valuesOfMainArray = (JSONObject) obj;

                        Long id = (Long) valuesOfMainArray.get("id");
                        String title = (String) valuesOfMainArray.get("title");
                        String link = bitbucket.getPullRequestsOfRepositoryWithoutApi(repository, user) + id;

                        pullRequest = new PullRequest(id, title, link);

                        repository.getPullRequests().add(this.pullRequest);

                        parserOfOnePullRequest.parseOnePR(bitbucket, repository, user, id);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
