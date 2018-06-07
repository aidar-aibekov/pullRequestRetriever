package main;

import consoleIO.TextInput;
import consoleIO.TextOutput;
import org.json.simple.parser.ParseException;
import parser.ParserOfListOfPullRequests;
import parser.SelectorByGivenReviewer;
import server.BitBucketServer;
import server.GitPlatform;
import unit.Repository;
import unit.User;

import java.io.IOException;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 */
public class Main {
    /**
     * Here we need these objects
     */
    private TextOutput textOutput;
    private TextInput textInput;
    private ParserOfListOfPullRequests parserOfListOfPullRequests;


    public Main(){
        textInput = new TextInput();
        textOutput = new TextOutput();
        parserOfListOfPullRequests = new ParserOfListOfPullRequests();

    }

    public static void main(String[] args) throws IOException, ParseException {

        Main main = new Main();
        //Initializes gitplatform, it is bitbucket
        GitPlatform bitbucket = new BitBucketServer();

        //Calls methods from classes TextOutput and TextInput
        //Asks name of repo
        main.textOutput.printTextEnterReposName();
        String repoName = main.textInput.takeInputStringFromUser();

        //Asks name of owner of repo given above
        main.textOutput.printTextEnterUsernameOfRepositoryOwner();
        String repoOwner = main.textInput.takeInputStringFromUser();

        //with given values creates repository and user
        Repository repository = new Repository(repoName, repoOwner);
        User userOwner = new User(repoOwner);

        //then parses PRs of given repo
        main.textOutput.printTextPleaseWait();
        main.parserOfListOfPullRequests.parseListOfPRs(bitbucket, repository, userOwner);

        //Print all PR from repo
        main.textOutput.printAllPullRequests(repository);

        // The next block of code is for check reviewers of PRs
        boolean run = true;
        do{
            //Prints if user wants to check reviewers PRs
            main.textOutput.printTextDoYouWantToContinue();
            String answerYesOrNo = main.textInput.takeInputStringFromUser();

            //if "yes" creates new User and selects PRs assigned to him
            if(answerYesOrNo.equalsIgnoreCase("yes")){
                main.textOutput.printTextEnterUsernameOfReviewer();
                String reviewersName = main.textInput.takeInputStringFromUser();

                User userReviewerContinued = new User(reviewersName);
                SelectorByGivenReviewer selectorByGivenReviewerContinued = new SelectorByGivenReviewer();

                main.textOutput.printPullRequestsOfGivenReviewer(selectorByGivenReviewerContinued.choosePullRequestWithGivenReviewer(repository, userReviewerContinued));
            }
            //if "no" prints "Bye bye" and ends program
            if(answerYesOrNo.equalsIgnoreCase("no")){
                main.textOutput.printTextByeBye();
                run = false;
            }
            //it is for another answers like "g4i5t2h6u6b4s2u3c2k2s"
            if(!answerYesOrNo.equalsIgnoreCase("yes") && !answerYesOrNo.equalsIgnoreCase("no") ){
                main.textOutput.printTextSomethingGoesWrong();
            }

        }while(run == true);

    }
}
