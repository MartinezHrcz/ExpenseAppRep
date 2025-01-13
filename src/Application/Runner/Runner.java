package Application.Runner;

import Application.Exceptions.NumberOutOfRange;
import Application.Utils.Menu;

import java.util.Scanner;

public class Runner {
    //Menu items stored in local variable
    //ToDo: Store in a txt and read in on launch
    private final static String[] menuItems = {"Bevétel megadása", "Kiadások"};

    //Entry point
    public static void main(String[] args) {
        RunnerMainMenu();
    }

    //Main menu runner
    private static void RunnerMainMenu() {

        Scanner userInputSC = new Scanner(System.in);
        String input = "";
        //loop for the main menu
        while (input.trim().toLowerCase() != "exit"){
            //Menu util used to print out items
            Menu.displayMenuIndexed(menuItems);

            input = userInputSC.nextLine();
            //Redirecting and precheck
            UserInputRedirect(input);
        }
    }

    //This is where the program prechecks the input
    // and redirects to the correct next menu
    private static void UserInputRedirect(String input) {
        int inputInt;
        //Precheck

        //Checks if the input is blank
        //if blank returns to the RunnerMainMenu method
        if(input.isBlank()){
            return;
        }
        //Checks if the input is a number
        try{
            //Converting to an integer
            inputInt = Integer.parseInt(input);
            //Checks if a number is in valid range
            if (inputInt < 1 || inputInt > menuItems.length){
                System.out.println( new NumberOutOfRange(input).getMessage());
            }
        }
        catch (NumberFormatException e){
            System.out.println("Not a number");
        }

        //Redirecting
    }

}
