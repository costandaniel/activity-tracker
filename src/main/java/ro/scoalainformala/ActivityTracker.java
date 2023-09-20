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
                case 3 -> Service.displayStepsByGivenDay();
                case 4 -> Service.updateStepsForAGivenDay();
                case 5 -> "";
                case 6 -> "";
                case 7 -> "";
                case 8 -> "Goodbye!";
                default -> "Invalid option";
            };
            System.out.println(result);
        } while (option != 8);
    }
}
