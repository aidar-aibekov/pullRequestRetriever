package server;

import unit.Repository;
import unit.User;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 */
public interface GitPlatform {
    String getUrlToApiOfServer();
    String getUrlToWebsiteWithoutApi();
    String getPullRequestsOfRepositoryWithApi(Repository repository, User user);
    String getPullRequestsOfRepositoryWithoutApi(Repository repository, User user);

    String getPullRequestsPhrase();
    String getPullRequestsPhraseWithDash();

}
