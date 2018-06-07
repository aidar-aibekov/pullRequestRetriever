package unit;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * Simple Class for Pull Requests
 */
public class PullRequest {
    private Long id;
    private String title;
    private String link;
    private List<User> reviewers;

    public PullRequest(Long id, String title, String link){
        this.reviewers = new ArrayList<>();
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<User> reviewers) {
        this.reviewers = reviewers;
    }
}
