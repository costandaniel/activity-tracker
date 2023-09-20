package ro.scoalainformala.business;

import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    private static LocalDate[] dates = new LocalDate[100];
    private static int[] stepNumbers = new int[100];
    private static int entryCount = 0;
    public static String addNewActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of steps:");
        int steps = scanner.nextInt();

        System.out.println("Use present day? (y/n)");
        char affirm = scanner.next().charAt(0);

        LocalDate date = LocalDate.now();

        if (affirm != 'y' && affirm != 'n') {
            System.out.println("Input is not valid");
        }
        else if (affirm == 'n') {
            System.out.println("Input a custom date (yyyy-MM-dd): ");
            String customDate = scanner.next();
            date = LocalDate.parse(customDate);
        } else {
            date = LocalDate.now();
        }

        dates[entryCount] = date;
        stepNumbers[entryCount] = steps;
        entryCount++;

        return "Activity added";
    }

    public static String listAllDays() {
        System.out.println("List of saved days: ");

        for (int i = 0; i < entryCount; i++) {
            System.out.println("");
            System.out.println("Date: " + dates[i]);
            System.out.println("Steps: " + stepNumbers[i]);
            System.out.println("");
        }

        return "";
    }

    public static String displayStepsByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        LocalDate targetDate = LocalDate.parse(inputDate);

        System.out.println("Steps on " + targetDate + ":");

        for (int i = 0; i < entryCount; i++) {
            if (!dates[i].equals(targetDate)) {
                System.out.println("This date is not registered.");
            } else {
                System.out.println(stepNumbers[i]);

            }
        } return "";

    }

    public static String updateStepsByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        LocalDate targetDate = LocalDate.parse(inputDate);
        for (int i = 0; i < entryCount; i++) {
            if (dates[i].equals(targetDate)) {
                System.out.println("Are you sure you want to change the number of steps for " + targetDate + "? (y/n)");

                char affirm = scanner.next().charAt(0);

                if (affirm != 'y' && affirm != 'n') {
                    System.out.println("Input is not valid");
                } else if (affirm == 'y') {
                    System.out.println("Input the new number of steps: ");
                    int updatedSteps = scanner.nextInt();
                    stepNumbers[i] = updatedSteps;
                    System.out.println("Update was a success!");
                } else if (affirm == 'n') {
                    return "";
                }
            } else {
                System.out.println("This date is not registered.");
            }
        } return "";


    }

    public static String displayMostActiveDay() {
        if (entryCount == 0) {
            return "No activity data available.";
        }
        int mostSteps = stepNumbers[0];
        int mostActiveIndex = 0;
        for (int i = 0; i < entryCount; i++) {
            if (stepNumbers[i] > mostSteps) {
                mostSteps = stepNumbers[i];
                mostActiveIndex = i;
            }
        }

        LocalDate mostActiveDate = dates[mostActiveIndex];
        return "The most active day is " + dateToString(mostActiveDate) + ", with " + mostSteps + " steps.";
    }

    public static String displayLeastActiveDay() {
        if (entryCount == 0) {
            return "No activity data available.";
        }
        int leastSteps = stepNumbers[0];
        int leastActiveIndex = 0;
        for (int i = 1; i < entryCount; i++) {
            if (stepNumbers[i] < leastSteps) {
                leastSteps = stepNumbers[i];
                leastActiveIndex = i;
            }
        }

        LocalDate leastActiveDate = dates[leastActiveIndex];
        return "The least active day is " + dateToString(leastActiveDate) + ", with " + leastSteps + " steps.";
    }

    public static String displayAverageStepsPerDay() {
        if (entryCount == 0) {
            return "No activity data available.";
        }

        int totalSteps = 0;
        for (int i = 0; i < entryCount; i++) {
            totalSteps += stepNumbers[i];
        }

        double averageSteps = (double) totalSteps / entryCount;

        return "Average steps per day: " + averageSteps + " steps.";
    }

    public static String dateToString(LocalDate date) {
        return date.toString();
    }
}
