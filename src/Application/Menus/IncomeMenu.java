package Application.Menus;

import Application.Classes.Income;
import Application.Classes.ListIncomeExpenses;
import Application.Exceptions.NumberOutOfRange;
import Application.Utils.Menu;

import java.util.Scanner;

public class IncomeMenu {
    //Menu items stored in local variable
    private final static String[] MENU_ITEMS = {"Új Megadása", "Törlés", "Megtekintés", "Type \"exit\" to go back"};
    //Entry Point
    public static void RunIncome() {
        IncomeMainMenu();
    }
    //Main menu
    private static void IncomeMainMenu() {
        Scanner userInputSC = new Scanner(System.in);
        String input = "";

        while (input.trim().toLowerCase() != "exit"){
            //Menu util used for menu items
            Menu.displayMenuIndexed(MENU_ITEMS);
            //get input
            input = userInputSC.nextLine();

        }
    }
    private static void Redirecting(String input) {
        int inputInt = 0;
        //Precheck
        //Checks if the input is blank
        //if blank returns to the RunnerMainMenu method
        if(input.isBlank()){
            return;
        }
        //Checks if the input is a number
        try{
            //Converting to an integer
            inputInt = Integer.parseInt(input.trim());
            //Checks if a number is in valid range
            if (inputInt < 1 || inputInt > MENU_ITEMS.length){
                System.out.println( new NumberOutOfRange(input).getMessage());
            }
        }
        catch (NumberFormatException e){
            System.out.println("Not a number");
        }

        //Redirecting
        switch (inputInt){
            case 1: AddIncome();break;
            case 2: RemoveIncome();break;
            case 3: ShowIncome();break;
        }
    }

    private static void AddIncome() {
        Scanner userIncInputSC = new Scanner(System.in);
        Income i;

        System.out.println("Is this income reoccuring? (Y/N)");
        String reo = userIncInputSC.nextLine();


        System.out.println("Name of income: ");
        String name = userIncInputSC.nextLine();
        System.out.println("Description of income: ");
        String description = userIncInputSC.nextLine();
        System.out.println("Amount of income: ");
        double amount=0;
        do {
            amount = userIncInputSC.nextDouble();
        }
        while (amount < 0);
        if (reo.equals("Y")) {
            System.out.println("Date (Day of month) of reoccurenc: ");
            int date;
            try {
                date = Integer.parseInt(userIncInputSC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid date, defaulting to 1");
                date = 1;
            }
            i = new Income(name,amount,description,date);
        }
        else{
            i = new Income(name,amount,description);
        }
        ListIncomeExpenses.IncomeList.add(i);
    }

    private static void RemoveIncome() {

    }

    private static void ShowIncome() {

    }
}
