package consoleIO;

import unit.PullRequest;
import unit.Repository;

import java.util.List;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 */
public class TextOutput {
    /**
     * This data fields contain special string values as sentences.
     * With this sentences program has a conversation with user.
     */
    private String textEnterReposName;
    private String textEnterUsernameOfRepositoryOwner;
    private String textEnterUsernameOfReviewer;
    private String textPleaseWait;
    private String textDoYouWantToContinue;
    private String textByeBye;
    private String textSomethingGoesWrong;

    public TextOutput(){
        textEnterReposName = "Enter name of the repository below:";
        textEnterUsernameOfRepositoryOwner = "Enter name of project or username who owns this repository below";
        textEnterUsernameOfReviewer = "Enter username of reviewer below:";
        textPleaseWait = "Please wait... Required repository is loading";
        textDoYouWantToContinue = "Do you want to check the user who review pullrequests? Write YES or NO";
        textByeBye = "Bye bye!";
        textSomethingGoesWrong = "Something goes wrong, check it.";
    }
    /**
     * Prints all pull requests at given repository.
     * As parameter we give our created repository in Main class.
     */
    public void printAllPullRequests(Repository repository){
        int i = 1;
        System.out.println("Here is list of pullrequests of the repository  :");
        for(PullRequest allPRs: repository.getPullRequests()){
            System.out.println(i+ ". Title: " + allPRs.getTitle());
            System.out.println("Link: " + allPRs.getLink());
            System.out.println();
            i++;
        }
    }
    /**
     * Prints all pull requests in this repository that the user is reviewing.
     * As parameter we give already sorted List of all pullrequest in repository.
     * Sorting is realzied at class SelectorByGivenReviewer in package parser.
     * So this method do not check reviewer of pull requests, that do just printing of given List<>.
     */
    public void printPullRequestsOfGivenReviewer(List<PullRequest> pullRequests) {
        int i = 1;
        if (pullRequests.isEmpty() == true) {
            System.out.println("This user has not any pullrequests to review.");
        }
        if (pullRequests.isEmpty() == false) {
            System.out.println("Here is list of pullrequests where you are a reviewer:");
            for (PullRequest allPRsForGivenReviewer : pullRequests) {
                System.out.println(i + ". Title: " + allPRsForGivenReviewer.getTitle());
                System.out.println("Link: " + allPRsForGivenReviewer.getLink());
                System.out.println();
                i++;
            }
        }
    }

    /**
     * Next 7 Methods print data fields, which are placed above.
     */
    public void printTextEnterReposName(){
        System.out.println(getTextEnterReposName());
    }

    public void printTextEnterUsernameOfRepositoryOwner(){
        System.out.println(getTextEnterUsernameOfRepositoryOwner());
    }

    public void printTextEnterUsernameOfReviewer(){
        System.out.println(getTextEnterUsernameOfReviewer());
    }

    public void printTextPleaseWait(){
        System.out.println(getTextPleaseWait());
    }

    public void printTextDoYouWantToContinue(){
        System.out.println(getTextDoYouWantToContinue());
    }

    public void printTextByeBye(){
        System.out.println(getTextByeBye());
    }

    public void printTextSomethingGoesWrong(){
        System.out.println(getTextSomethingGoesWrong());
    }



    public String getTextEnterReposName() {
        return textEnterReposName;
    }

    public void setTextEnterReposName(String textEnterReposName) {
        this.textEnterReposName = textEnterReposName;
    }

    public String getTextEnterUsernameOfRepositoryOwner() {
        return textEnterUsernameOfRepositoryOwner;
    }

    public void setTextEnterUsernameOfRepositoryOwner(String textEnterUsernameOfRepositoryOwner) {
        this.textEnterUsernameOfRepositoryOwner = textEnterUsernameOfRepositoryOwner;
    }

    public String getTextEnterUsernameOfReviewer() {
        return textEnterUsernameOfReviewer;
    }

    public void setTextEnterUsernameOfReviewer(String textEnterUsernameOfReviewer) {
        this.textEnterUsernameOfReviewer = textEnterUsernameOfReviewer;
    }

    public String getTextPleaseWait() {
        return textPleaseWait;
    }

    public void setTextPleaseWait(String textPleaseWait) {
        this.textPleaseWait = textPleaseWait;
    }

    public String getTextDoYouWantToContinue() {
        return textDoYouWantToContinue;
    }

    public void setTextDoYouWantToContinue(String textDoYouWantToContinue) {
        this.textDoYouWantToContinue = textDoYouWantToContinue;
    }

    public String getTextByeBye() {
        return textByeBye;
    }

    public void setTextByeBye(String textByeBye) {
        this.textByeBye = textByeBye;
    }

    public String getTextSomethingGoesWrong() {
        return textSomethingGoesWrong;
    }

    public void setTextSomethingGoesWrong(String textSomethingGoesWrong) {
        this.textSomethingGoesWrong = textSomethingGoesWrong;
    }
}
