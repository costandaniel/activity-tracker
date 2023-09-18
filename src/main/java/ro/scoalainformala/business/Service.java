package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);
    static int[] stepsArray = {};
    static String[] daysArray = {};

    public static String addNewActivity() {
        System.out.print("Add new date in the format 'yyyy-MM-dd': ");
        String date = Utilities.getDate(scanner.next());
        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);

        if (date.contains("Invalid")) {
            return date;
        } else {
            if (indexOfDay != -1) {
                return date + " already exists";
            } else {
                daysArray = Utilities.addStringArray(daysArray, date);
            }
            System.out.print("Add number of steps: ");
            int numberOfSteps;
            if (scanner.hasNextInt()) {
                numberOfSteps = scanner.nextInt();
                stepsArray = Utilities.addIntArray(stepsArray, numberOfSteps);
            } else {
                return "Invalid steps input";
            }
        }

        return "Activity successfully added for " + date;
    }

    public static String listAllDays() {
        if (daysArray.length == 0) {
            return "No activity added yet";
        }

        return Utilities.concatenateDaySteps(daysArray, stepsArray);
    }

    public static String displayStepsForDay() {
        System.out.print("Type the date in the format 'yyyy-MM-dd': ");
        String date = Utilities.getDate(scanner.next());
        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);

        if (date.contains("Invalid")) {
            return date;
        } else {
            if (indexOfDay == -1) {
                return date + " does not exist";
            }
        }

        return "The number of steps for " + date + " is " + stepsArray[indexOfDay];
    }

    public static String updateStepsForDay() {
        System.out.print("Type the date in the format 'yyyy-MM-dd': ");
        String date = Utilities.getDate(scanner.next());
        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);

        if (date.contains("Invalid")) {
            return date;
        } else {
            if (indexOfDay == -1) {
                return date + " does not exist";
            }
            System.out.print("Type the updated number of steps: ");
            int updatedStepsNumber = scanner.nextInt();

            if (updatedStepsNumber == stepsArray[indexOfDay]) {
                return "The new value is the same as the old value";
            } else {
                stepsArray[indexOfDay] = updatedStepsNumber;
            }
        }

        return "Activity successfully updated for " + date;
    }

    public static String displayMostActiveDay() {
        if (daysArray.length == 0) {
            return "No activity added yet";
        }

        int maximum = stepsArray[0];
        int indexOfMaximum = 0;
        for (int i = 1; i < stepsArray.length; i++) {
            if (stepsArray[i] > maximum) {
                maximum = stepsArray[i];
                indexOfMaximum = i;
            }
        }

        return "The most active day is " + daysArray[indexOfMaximum];
    }

    public static String displayLeastActiveDay() {
        if (daysArray.length == 0) {
            return "No activity added yet";
        }

        int minimum = stepsArray[0];
        int indexOfMinimum = 0;
        for (int i = 1; i < stepsArray.length; i++) {
            if (stepsArray[i] < minimum) {
                minimum = stepsArray[i];
                indexOfMinimum = i;
            }
        }

        return "The least active day is " + daysArray[indexOfMinimum];
    }

    public static String displayAverageStepsPerDay() {
        if (daysArray.length == 0) {
            return "No activity added yet";
        }

        int sum = 0;

        for (int steps : stepsArray) {
            sum = sum + steps;
        }

        return "The average steps per day is " + sum / stepsArray.length;
    }
}
