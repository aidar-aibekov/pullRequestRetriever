package server;

import unit.Repository;
import unit.User;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * this class is for git platform BitBucket
 */
public class BitBucketServer implements GitPlatform {

    private String urlToApiOfServer;//url for API bitbucket
    private String urlToWebsiteWithoutApi;//url for website of bitbucket without API
    private final String pullRequestsPhrase; //just "pullrequests"
    private final String pullRequestsPhraseWithDash;//just "pull-requests"

    public BitBucketServer(){
        urlToApiOfServer = "https://api.bitbucket.org/2.0/repositories/";
        urlToWebsiteWithoutApi = "https://bitbucket.org/";
        pullRequestsPhrase = "pullrequests/";
        pullRequestsPhraseWithDash = "pull-requests/";
    }

    /**
     *
     * @param repository
     * @param user
     * @return
     *
     * Here we make full link (url) to API Bitbucket for required repository of given user
     */
    @Override
    public String getPullRequestsOfRepositoryWithApi(Repository repository, User user) {
        String result;
        result = urlToApiOfServer + user.getUsername() + "/" + repository.getName() + "/" + pullRequestsPhrase;
        return result;
    }

    /**
     *
     * @param repository
     * @param user
     * @return
     *
     * Makes full link (url) to Bitbucket.org for required repository of given user
     */
    @Override
    public String getPullRequestsOfRepositoryWithoutApi(Repository repository, User user) {
        String result;
        result = urlToWebsiteWithoutApi + user.getUsername() + "/" + repository.getName() + "/" + pullRequestsPhraseWithDash;
        return result;
    }

    @Override
    public String getUrlToApiOfServer() {
        return urlToApiOfServer;
    }

    @Override
    public String getUrlToWebsiteWithoutApi() {
        return urlToWebsiteWithoutApi;
    }

    public void setUrlToApiOfServer(String urlToApiOfServer) {
        this.urlToApiOfServer = urlToApiOfServer;
    }

    public void setUrlToWebsiteWithoutApi(String urlToWebsiteWithoutApi) {
        this.urlToWebsiteWithoutApi = urlToWebsiteWithoutApi;
    }
    @Override
    public String getPullRequestsPhrase() {
        return pullRequestsPhrase;
    }
    @Override
    public String getPullRequestsPhraseWithDash() {
        return pullRequestsPhraseWithDash;
    }
}
