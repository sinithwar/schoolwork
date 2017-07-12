package firstsubroutines;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class firstsubroutines {
    public static void main(String[] args){
        // The following uncommented code was utilized to test the methods used in this program
//        String testerInput = "This Is a tEst.";
//        reverseUserInput(testerInput);
//        stripSpecialChars(testerInput);
// Alright, so this is here because I get confused.
// 1. Program needs to print out lower case first, but this also has to be stripped
// 2. Program should print out reverse string.
// 3. Program should now tell use if it is a Palindrome
        System.out.println("Please enter a word or sentence that you think is a Palindrome.");
        String userInput = userScanner();
        userInput = stripSpecialChars(userInput);
        String originalInput = userInput;
        userInput = reverseUserInput(userInput);
        palindromeTest(userInput,originalInput);
    }
    // This is a subroutine that is specifically designed to handle reversing
    // a String. The String class utilizes the StringBuilder, so I figured
    // I would use that class to reverse the String rather than do it by hand.
    // However, StringBuilder is StringBuilder and not String, so I had to convert
    // the StringBuilder back to String and this is the return.
    public static String reverseUserInput(String userInput){
        String userOutput = new StringBuilder(userInput).reverse().toString();
	    System.out.println(userOutput);
	    return userOutput;
    }
    // This subroutine removes all non-letters by simplying replacing anything that
    // doesn't represent a letter via RegEx. Simple and Concise.
    public static String stripSpecialChars(String userInput){
        String userOutput = userInput.toLowerCase();
        // By using RegEx, I remove the need for a try block here as RegEx will also handle return key characters
        userOutput = userOutput.replaceAll("[^a-zA-Z]","");
        System.out.println(userOutput);
        return userOutput;
    }
    // Alright, this one was the tricky one because of user input.
    // In order to access the String that the user puts in outside of
    // the try block so that I can return it, I have to hoist it
    // Once I hoist the variable, I then try to see if the user puts in a valid String.
    // If the user doesn't put in a proper String, the program doesn't end. Instead,
    // it prints out the problem and restarts the userScanner subroutine.
    // The odds of it failing this test are slim since 
    // once it passes through stripSpecialChars, it will remove anything that isn't a letter
    // I can't imagine how this would fail actually... we'll call it a feature :)
    public static String userScanner(){
        String userInputCapture = "";
        try{
            Scanner userInput = new Scanner(System.in);
            userInputCapture = userInput.nextLine();
            userInput.close();
        }catch(java.util.InputMismatchException e){
            System.out.println("I'm sorry, that's not valid. Please try again.");
            userScanner();
        }
        // This was a test to make sure user input capture occured
//        System.out.println(userInputCapture);
        return userInputCapture;
    }
    public static void palindromeTest(String changedInput, String originalInput){
        String classyString = "";
        // Console Flare
        try{
            System.out.println("Now testing to see if this word is a Palindrome");
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print(".");
        }catch(InterruptedException e){
            System.out.println("Exiting...");
        }
        // Actual check to see if the two are matching
        // Equals is a method specifically designed to see if the values are the same
        if(changedInput.equals(originalInput)){
            classyString = "This is indeed a Palindrome.";
        }else{
            classyString = "I'm quite sorry, but this is not a Palindrome.";
        }
        
        System.out.println(classyString);
    }
}
