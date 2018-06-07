package unit;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * Simple Class for User
 */
public class User {
    private String userName;
    private String linkToAccount;

    public User(String userName, String linkToAccount){
        this.userName = userName;
        this.linkToAccount = linkToAccount;
    }

    public User(String userName){
        this.userName = userName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getLinkToAccount() {
        return linkToAccount;
    }

    public void setLinkToAccount(String linkToAccount) {
        this.linkToAccount = linkToAccount;
    }
}
