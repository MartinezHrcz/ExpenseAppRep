package Application.Classes;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    /*
    |---------------------------|
    |ToDo: Make the income      |
    |and expenses into          |
    |a single method with a bool|
    |___________________________|
    */


public class ListIncomeExpenses {
    //Stores the Income values
    public static List<Income> IncomeList = new ArrayList<>();
    //Stores the Expense values
    public static List<Expenses> ExpensesList= new ArrayList<>();

    //Income methods:

    //Adds value to Income list
    public static void AddtoIncomeList() throws IOException {
        Scanner userIncInputSC = new Scanner(System.in);
        Income i;

        System.out.println("Is this income reoccuring? (Y/N)");
        String reo = userIncInputSC.nextLine();

        System.out.println("Name of income: ");
        String name = userIncInputSC.nextLine();

        System.out.println("Description of income: ");
        String description = userIncInputSC.nextLine();
        //amount is asked until it is valid
        System.out.println("Amount of income: ");
        double amount=0;
        do {
            try{
                amount = Double.parseDouble(userIncInputSC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        while (amount < 0);
        //Only gets called if the income is reoccuring
        if (reo.equals("Y")) {
            System.out.println("Date (Day of month) of reoccurenc: ");
            int date = 0;
            //tries to get a date if it isn't in the valid range
            do {
                //for checking if the value is
                try {
                    date = Integer.parseInt(userIncInputSC.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid date, please try again!");
                }
            }
            while (date < 1 || date > 30) ;
            i = new Income(name,amount,description,date);
        }
        //if the income isn't reoccuring
        else{
            i = new Income(name,amount,description);
        }
        IncomeList.add(i);
    }

    //Removes specified Income from IncomeList
    public static void RemoveFromIncomeList() throws IOException {
        //Precheck if Incomelist is empty
        if (IncomeList.isEmpty()) {
            System.out.println("Nothing to remove");
            return;
        }

        int index = 0;
        //Listsincome list but only it's name
        for (Income i : IncomeList) {
            index++;
            System.out.println(index + "." +i.getNameOfIncome());
        }

        Scanner userDeleteSC = new Scanner(System.in);
        String input;
        int inputInt = 0;
        //User input of which index to delete
        do{
            try{
                input = userDeleteSC.nextLine();
                inputInt = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input, please try again!");
            }
        }while (inputInt < 1 || inputInt > IncomeList.size());
        //Removes the selected object
        IncomeList.remove(IncomeList.get(inputInt-1));
    }

    //Prints IncomeList to console
    public static void ListIncomeList(boolean detailed) throws IOException {
        int index = 0;
        for (Income income : ListIncomeExpenses.IncomeList){
            index++;
            if (detailed == true) {
                System.out.println(index + ". " + income.toString());
            } else {
                System.out.println(index + ". " + income.getNameOfIncome() + ": " + income.getIncomeAmount());
            }

        }
        System.out.println("Press any key to continue...");
        System.in.read();
    }
    //-------------------------------------------

    //Expenses methods:

    //Adds value to Expenses list
    public static void AddtoExpensesList() throws IOException {
        Scanner userExpInputSC = new Scanner(System.in);
        Expenses e;

        System.out.println("Is this expense reoccuring? (Y/N)");
        String reo = userExpInputSC.nextLine();

        System.out.println("Name of expense: ");
        String name = userExpInputSC.nextLine();

        System.out.println("Description of expense:");
        String description = userExpInputSC.nextLine();

        System.out.println("Is this expense essential? (Y/N)");
        String ess = userExpInputSC.nextLine();
        while (!(ess.trim().toLowerCase().equals("y") || ess.trim().toLowerCase().equals("n"))) {
            System.out.println("Invalid input, please try again!");
            ess = userExpInputSC.nextLine();
        }

        //amount is asked until it is valid
        System.out.println("Amount of expense: ");
        double amount=0;
        do {
            try
            {
                amount = Double.parseDouble(userExpInputSC.nextLine());
            } catch (NumberFormatException ex) {
                System.out.printf("Invalid input, please try again!");
            }

        }
        while (amount < 1);
        //Only gets called if the income is reoccuring
        if (reo.trim().toLowerCase().equals("y")) {
            System.out.println("Date (Day of month) of reoccurenc: ");
            int date = 0;
            //tries to get a date if it isn't in the valid range
            do {
                //for checking if the value is
                try {
                    date = Integer.parseInt(userExpInputSC.nextLine());
                } catch (NumberFormatException error) {
                    System.out.println("Invalid date, please try again!");
                }
            }
            while (date < 1 || date > 30);
            //here object
            e = ess.trim().toLowerCase().equals("y") ?
                    new Expenses(name,description, amount, true, date)
                    :
                    new Expenses(name,description,amount,false,date);
        }
        //if the expense isn't reoccuring
        else{
            e = ess.trim().toLowerCase().equals("y") ?
                    new Expenses(name,description, amount, true)
                    :
                    new Expenses(name,description,amount,false);
        }
        ExpensesList.add(e);
    }

    //Removes specified Expense from ExpensesList
    public static void RemoveFromExpensesList() throws IOException {
        //Precheck if ExpensesList is empty
        if (ExpensesList.isEmpty()) {
            System.out.println("Nothing to remove");
            return;
        }

        int index = 0;
        //ListExpense list but only it's name
        for (Expenses expenses : ExpensesList) {
            index++;
            System.out.println(index + "." +expenses.getName());
        }

        Scanner userDeleteSC = new Scanner(System.in);
        String input;
        int inputInt = 0;
        //User input of which index to delete
        do{
            try{
                input = userDeleteSC.nextLine();
                inputInt = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input, please try again!");
            }
        }while (inputInt < 1 || inputInt > ExpensesList.size());
        //Removes the selected object
        ExpensesList.remove(ExpensesList.get(inputInt-1));
        System.out.println("Removed!");
        System.out.println("Press any key to continue...");
        System.in.read();
    }

    //Prints ExpensesList to console
    public static void ListExpensesList(boolean detailed) throws IOException {
        int index = 0;
        for (Expenses expense : ExpensesList) {
            index++;
            if (detailed == true) {
                System.out.println(index + ". " + expense.toString());
            }
            else {
                System.out.println(index + ". " + expense.getName() + ": " + expense.getAmount());
            }
        }
        System.out.println("Press any key to continue...");
        System.in.read();
    }
    //--------------------------------------------
}