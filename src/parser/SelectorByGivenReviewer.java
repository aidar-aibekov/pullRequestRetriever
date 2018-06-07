package parser;

import unit.PullRequest;
import unit.Repository;
import unit.User;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * Here we select PR where giver User is reviewer
 */
public class SelectorByGivenReviewer {
    //array where we will save sorted PRs
    private List<PullRequest> pullRequestsInArrayForRequiredReviewer;

    public SelectorByGivenReviewer(){
        pullRequestsInArrayForRequiredReviewer = new ArrayList<>();
    }

    /**
     *
     * @param repository
     * @param user
     * @return
     *
     * Sorts PR from given repo and return right Arraylist with PRs
     */
    public List<PullRequest> choosePullRequestWithGivenReviewer(Repository repository, User user){
        for(PullRequest pRObjects:repository.getPullRequests()){
            for(User userObject: pRObjects.getReviewers()){
                if(userObject.getUsername().equalsIgnoreCase(user.getUsername())){
                    pullRequestsInArrayForRequiredReviewer.add(pRObjects);
                }
            }
        }
        return pullRequestsInArrayForRequiredReviewer;
    }

    public List<PullRequest> getPullRequestsInArrayForRequiredReviewer() {
        return pullRequestsInArrayForRequiredReviewer;
    }

    public void setPullRequestsInArrayForRequiredReviewer(List<PullRequest> pullRequestsInArrayForRequiredReviewer) {
        this.pullRequestsInArrayForRequiredReviewer = pullRequestsInArrayForRequiredReviewer;
    }
}
