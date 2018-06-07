package consoleIO;

import java.util.Scanner;
/**
 * Created by Aidar Aibekov, special for Zensoft Test Assignment
 * This class is for take input values from User in console.
*/
public class TextInput {
    private Scanner scanner;

    public TextInput(){
        scanner = new Scanner(System.in);
    }


    public String takeInputStringFromUser(){
        return scanner.nextLine();
    }


}
