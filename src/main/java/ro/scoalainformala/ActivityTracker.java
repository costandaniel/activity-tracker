package ro.scoalainformala;

import ro.scoalainformala.business.Service;
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
                case 1 -> Service.addNewActivity();
                case 2 -> Service.listAllDays();
                case 3 -> Service.displayStepsForDay();
                case 4 -> Service.updateStepsForDay();
                case 5 -> Service.displayMostActiveDay();
                case 6 -> Service.displayLeastActiveDay();
                case 7 -> "";
                case 8 -> "Goodbye!";
                default -> "Invalid option";
            };
            System.out.println(result);
        } while (option != 8);
    }
}
