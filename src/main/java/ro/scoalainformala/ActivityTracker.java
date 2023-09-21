package ro.scoalainformala;

import ro.scoalainformala.business.Service;
import ro.scoalainformala.menu.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivityTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<String>();
        ArrayList<Integer> steps = new ArrayList<Integer>();

        int option;
        do {
            System.out.println(Menu.createMenu());
            option = scanner.nextInt();
            // switch expression
            switch (option) {
                case 1 -> Service.addNewStepsPerDay(steps, days);
                case 2 -> Service.listAllSteps(steps,days);
                case 3 -> Service.displayStepsForAGivenDay(steps, days);
                case 4 -> Service.updateStepsForAGivenDay(steps, days);
                case 5 -> Service.theMostActiveDay(steps, days);
                case 6 -> Service.theLeastActiveDay(steps,days);
                case 7 -> Service.averageSteps(steps);
                case 8 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option");
            };
        } while (option != 8);
    }
}
