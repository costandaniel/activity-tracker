package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);

    static int[] stepsArray = {};
    static String[] daysArray = {};

    public static String addNewActivity() {

        System.out.print("Add new date in the format 'yyyy-MM-dd': ");
        String date = scanner.next();
        String newDate = Utilities.formatDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
        int indexOfDay = Utilities.stringBinarySearch(daysArray, newDate);

        if (indexOfDay != -1) {
            return "This day already exists";
        } else {
            daysArray = Utilities.addStringArray(daysArray, newDate);
        }

        System.out.print("Add number of steps: ");
        int numberOfSteps = scanner.nextInt();
        stepsArray = Utilities.addIntArray(stepsArray, numberOfSteps);

        return "Activity successfully added for " + newDate;
    }

    public static String listAllDays() {
        return Utilities.concatenateDaySteps(daysArray, stepsArray);
    }

    public static String displayStepsForDay() {
        System.out.print("Type the date in the format 'yyyy-MM-dd': ");
        String date = scanner.next();

        String newDate = Utilities.formatDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));

        int indexOfDay = Utilities.stringBinarySearch(daysArray, newDate);
        if (indexOfDay == -1) {
            return "The chosen date does not exist";
        }

        return "The number of steps for " + newDate + " is " + stepsArray[indexOfDay];
    }

    public static String updateStepsForDay() {
        System.out.print("Type the date in the format 'yyyy-MM-dd': ");
        String date = scanner.next();

        String newDate = Utilities.formatDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));

        int indexOfDay = Utilities.stringBinarySearch(daysArray, newDate);
        if (indexOfDay == -1) {
            return "The chosen date does not exist";
        }
        System.out.print("Type the updated number of steps: ");
        int updatedStepsNumber = scanner.nextInt();

        if (updatedStepsNumber == stepsArray[indexOfDay]) {
            return "The new value is the same as the old value";
        } else {
            stepsArray[indexOfDay] = updatedStepsNumber;
        }

        return "Activity successfully updated for " + newDate;
    }

    public static String displayMostActiveDay() {

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
}
