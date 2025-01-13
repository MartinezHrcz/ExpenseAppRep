package Application.Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListIncomeExpenses {
    //Stores the Income values
    public static List<Income> IncomeList = new ArrayList<>();
    //Stores the Expense values
    public static List<Expenses> ExpensesList= new ArrayList<>();

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
            amount = userIncInputSC.nextDouble();
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
    public static void ListIncomeList() throws IOException {
        int index = 0;
        for (Income income : ListIncomeExpenses.IncomeList){
            index++;
            System.out.println(index + '\n' + ". " + income.toString());
        }
        System.out.println("Press any key to continue...");
        System.in.read();
    }

}