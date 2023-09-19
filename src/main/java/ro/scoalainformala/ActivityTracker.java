package ro.scoalainformala;

import static ro.scoalainformala.business.Service.*;
import ro.scoalainformala.menu.Menu;

import java.util.Scanner;



public class ActivityTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println(Menu.createMenu());
            option = scanner.nextInt();
            // switch expression
            String result = switch (option) {
                case 1 -> addNewActivity();
                case 2 -> listAllDays();
                case 3 -> listStepsForAGivenDay();
                case 4 -> updateStepsForADay();
                case 5 -> mostActiveDay();
                case 6 -> leastActiveDay();
                case 7 -> averageStepsPerDays();
                case 8 -> "Goodbye!";
                default -> "Invalid option";
            };
            System.out.println(result);
        } while (option != 8);
    }
}
