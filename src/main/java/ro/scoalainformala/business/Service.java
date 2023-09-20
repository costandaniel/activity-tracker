package ro.scoalainformala.business;

import java.util.Scanner;

public class Service {

    private static String[][] activities = new String[30][2];
    private static int activityCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static String addNewActivity() {
        System.out.print("Add date: ");
        String date = scanner.nextLine();
        activities[activityCount][0] = date;
        System.out.print("Add number of steps: ");
        String steps = scanner.nextLine();
        activities[activityCount][1] = steps;
        activityCount++;

        return "Activity added";
    }

    public static String listAllDays() {
        String days = "";
        for (int i = 0; i < activities.length; i++) {
            days = days + (activities[i][0]) + "\n";
        }

        return "The days are: " + "\n" + days;
    }

    public static String displayStepsByGivenDay() {
        System.out.print("Display steps by given day: ");
        String date = scanner.nextLine();
        for (int i = 0; i < activities.length; i++) {
            if (activities[i][0].equals(date)) {
                return "Steps for day " + activities[i][1];
            }
        }

        return "No steps found for " + date;
    }

    public static String updateStepsForAGivenDay() {
        System.out.print("Update steps for date: ");
        String date = scanner.nextLine();
        System.out.print("Please input number of steps: ");
        String steps = scanner.nextLine();

        for (int i = 0; i < activities.length; i++) {
            if (activities[i][0].equals(date)) {
                activities[i][1] = steps;
                return "Steps updated for day " + activities[i][0] + " with " + steps + " steps.";
            }
        }

        return "No steps found for " + date;
    }


    //1 Add steps for a new day
    //2 List all days
    //3 Display steps for a given day
    //4 Update steps for given day
    //5 Display most active day
    //6 Display least active day
    //7 Display average steps per day
}
