package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);
    static int[] stepsArray = {};
    static String[] daysArray = {};
    static String invalid = "Invalid";
    static String noActivityAddedYet = "No activity added yet";
    static LocalDate[] datesArray = {};

    public static String addNewActivity() {
        System.out.println("Add new date, but be careful that dates must be entered chronologically");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        System.out.print("Day: ");
        int day = scanner.nextInt();
        String date = Utilities.createDate(year, month, day);

        datesArray = Utilities.makeDateArray(datesArray, year, month, day);

        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);
        int numberOfSteps;

        if (date.contains(invalid)) {
            return date;
        } else {
            if (indexOfDay != -1) {
                return date + " already exists";
            } else {
                daysArray = Utilities.formatDateArray(datesArray);
            }
            System.out.print("Add number of steps: ");
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
            return noActivityAddedYet;
        }

        return Utilities.concatenateDaySteps(daysArray, stepsArray);
    }

    public static String displayStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        System.out.print("Day: ");
        int day = scanner.nextInt();

        String date = Utilities.createDate(year, month, day);
        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);

        if (date.contains(invalid)) {
            return date;
        } else {
            if (indexOfDay == -1) {
                return date + " does not exist";
            }
        }

        return "The number of steps for " + date + " is " + stepsArray[indexOfDay];
    }

    public static String updateStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        System.out.print("Day: ");
        int day = scanner.nextInt();

        String date = Utilities.createDate(year, month, day);
        int indexOfDay = Utilities.stringBinarySearch(daysArray, date);

        if (date.contains(invalid)) {
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
            return noActivityAddedYet;
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
            return noActivityAddedYet;
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
            return noActivityAddedYet;
        }

        int sum = 0;

        for (int steps : stepsArray) {
            sum = sum + steps;
        }

        return "The average steps per day is " + sum / stepsArray.length;
    }
}
