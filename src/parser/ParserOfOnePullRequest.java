package parser;

import connection.ConnectionToOnePRAPI;
import other.FirstLastInArray;
import server.GitPlatform;
import unit.Repository;
import unit.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * In this class we parse data from API gitplatform page with one pull request
 */
public class ParserOfOnePullRequest {

    private ConnectionToOnePRAPI connectionToOnePRAPI;
    private String parsedDataFromURLAsString;

    private User userExample;
    private FirstLastInArray firstLastInArray;

    public ParserOfOnePullRequest(){
        firstLastInArray = new FirstLastInArray();
    }

    /**
     *
     * @param bitbucket
     * @param repository
     * @param user
     * @param id
     * @throws IOException
     * @throws ParseException
     *
     * Parses json from API bitbucket
     * as parameters we give gitplatform and and objects created in class Main
     * We parse one pull request
     * We get reviewers from the PR and add it to Arraylist of pull request object
     */
    public void parseOnePR(GitPlatform bitbucket, Repository repository, User user, Long id) throws IOException, ParseException {
        connectionToOnePRAPI = new ConnectionToOnePRAPI();
        connectionToOnePRAPI.connectWithURL(bitbucket, repository, user, id);

        if(connectionToOnePRAPI.getResponseCode() == 404)
            System.out.println("ERROR 404 NOT FOUND");
        if(connectionToOnePRAPI.getResponseCode() != 200)
            throw new RuntimeException("HttpResponseCode: " + connectionToOnePRAPI.getResponseCode());
        if(connectionToOnePRAPI.getResponseCode() == 200){
            try {
                BufferedReader bufferedReaderMain = new BufferedReader(new InputStreamReader(connectionToOnePRAPI.getUrl().openStream()));
                JSONParser parserForJsonMain = new JSONParser();

                while (null != (parsedDataFromURLAsString = bufferedReaderMain.readLine())) {
                    JSONObject jsonObjectMain = (JSONObject)parserForJsonMain.parse(parsedDataFromURLAsString);
                    JSONArray jsonArrayMain = (JSONArray)jsonObjectMain.get("reviewers");
                    for (Object obj : jsonArrayMain) {
                        JSONObject valuesOfMainArray = (JSONObject) obj;

                        String userName = (String) valuesOfMainArray.get("username");
                        String linkToAccount = bitbucket.getUrlToWebsiteWithoutApi()+userName;

                        userExample = new User(userName, linkToAccount);

                        firstLastInArray.getLast(repository.getPullRequests()).getReviewers().add(this.userExample);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
