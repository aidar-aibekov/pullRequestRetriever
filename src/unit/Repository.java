package unit;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * Simple Class for Repository
 */
public class Repository {
    private String name;
    private String link;
    private String owner;
    private List<PullRequest> pullRequests;

    public Repository(String name, String owner){
        pullRequests = new ArrayList<>();
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<PullRequest> getPullRequests() {
        return pullRequests;
    }

    public void setPullRequests(List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
    }
}
