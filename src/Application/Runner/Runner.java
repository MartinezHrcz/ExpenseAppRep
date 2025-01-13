package Application.Runner;

import Application.Utils.Menu;

import java.util.Scanner;

public class Runner {

    private final static String[] menuItems = {"Bevétel megadása", "Kiadások"};

    public static void main(String[] args) {
        RunnerMainMenu();
    }

    private static void RunnerMainMenu() {
        Scanner userInputSC = new Scanner(System.in);
        String input = "";
        while (input.trim().toLowerCase() != "exit"){
            Menu.displayMenuIndexed(menuItems);
            input = userInputSC.nextLine();
        }
    }
    private static void

}
