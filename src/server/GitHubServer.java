package server;

import unit.Repository;
import unit.User;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 */
public class GitHubServer implements GitPlatform {
    private String urlToApiOfServer;
    private String urlToWebsiteWithoutApi;

    @Override
    public String getUrlToApiOfServer() {
        return urlToApiOfServer;
    }

    @Override
    public String getUrlToWebsiteWithoutApi() {
        return urlToWebsiteWithoutApi;
    }

    @Override
    public String getPullRequestsOfRepositoryWithApi(Repository repository, User user) {
        return null;
    }

    @Override
    public String getPullRequestsOfRepositoryWithoutApi(Repository repository, User user) {
        return null;
    }

    @Override
    public String getPullRequestsPhrase() {
        return null;
    }

    @Override
    public String getPullRequestsPhraseWithDash() {
        return null;
    }

}
