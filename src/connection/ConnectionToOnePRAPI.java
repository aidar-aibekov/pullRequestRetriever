package connection;

import server.GitPlatform;
import unit.Repository;
import unit.User;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 */
public class ConnectionToOnePRAPI{
    /**
     * In this class we need next three data fields
     */
    private URL url; // object of class URL from java.net
    private HttpURLConnection connection;// object of class HttpURLConnection from java.net
    private int responseCode; // data field as Integer for saving responscode of connectrion

    public ConnectionToOnePRAPI() {
    }

    /**
     * Creates connection with gitplatform API to the page of one pull request
     * In this case it is Bitbucket
     * From this connection we get response code
     * As parameters we give objects created in class Main
     */
    public void connectWithURL(GitPlatform gitPlatform, Repository repository, User user, Long id) throws IOException {
        url = new URL(gitPlatform.getPullRequestsOfRepositoryWithApi(repository, user)+id);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        responseCode = connection.getResponseCode();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    public void setConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
