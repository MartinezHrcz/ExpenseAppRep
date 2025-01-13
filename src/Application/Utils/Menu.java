package Application.Utils;

import java.util.Arrays;

public class Menu {

    public static void displayMenu(String[] menuItems) {
        Arrays.stream(menuItems).forEach(System.out::println);
    }

    public static void displayMenuIndexed(String[] menuItems) {
        int index = 0;
        for(String item : menuItems) {
            index++;
            System.out.println(index+"."+item);
        }
    }
}
