package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);
    static String invalid = "Invalid";
    static String noActivityAddedYet = "No activity added yet";
    static String[] activity = {};

    public static String addNewActivity() {
        System.out.println("Add new date:");
        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Day: ");
        int day = scanner.nextInt();

        String formatedDate = Utilities.createFormattedDate(year, month, day);
        String[] copyOfActivityArray = Utilities.copyPopulateArray(activity);

        if (formatedDate.contains(invalid)) {
            return formatedDate;
        } else {
            LocalDate rawDate = LocalDate.of(year, month, day);
            int indexOfDay = Utilities.stringBinarySearch(copyOfActivityArray, rawDate.toString());
            if (indexOfDay != -1) {
                return formatedDate + " already exists";
            } else {
                System.out.print("Add number of steps: ");
                if (scanner.hasNextInt()) {
                    int numberOfSteps = scanner.nextInt();
                    activity = Utilities.createActivityArray(activity, year, month, day, numberOfSteps);
                } else {
                    return "Invalid steps input";
                }
            }
        }

        Arrays.sort(activity);
        return "Activity successfully added for " + formatedDate;
    }

    public static String listAllDays() {
        if (activity.length == 0) {
            return noActivityAddedYet;
        }

        return Utilities.concatenateDaySteps(activity);
    }

    public static String displayStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Day: ");
        int day = scanner.nextInt();

        String formatedDate = Utilities.createFormattedDate(year, month, day);
        String[] copyOfActivityArray = Utilities.copyPopulateArray(activity);
        int indexOfDay;

        if (formatedDate.contains(invalid)) {
            return formatedDate;
        } else {
            LocalDate rawDate = LocalDate.of(year, month, day);
            indexOfDay = Utilities.stringBinarySearch(copyOfActivityArray, rawDate.toString());
            if (indexOfDay == -1) {
                return formatedDate + " does not exist";
            }
        }

        return "The number of steps for " + formatedDate + " is " + activity[indexOfDay].substring(13);
    }

    public static String updateStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Day: ");
        int day = scanner.nextInt();

        String formatedDate = Utilities.createFormattedDate(year, month, day);
        String[] copyOfActivityArray = Utilities.copyPopulateArray(activity);
        int indexOfDay;

        if (formatedDate.contains(invalid)) {
            return formatedDate;
        } else {
            LocalDate rawDate = LocalDate.of(year, month, day);
            indexOfDay = Utilities.stringBinarySearch(copyOfActivityArray, rawDate.toString());
            if (indexOfDay == -1) {
                return formatedDate + " does not exist";
            }
            System.out.print("Type the updated number of steps: ");
            int updatedStepsNumber = scanner.nextInt();

            if (updatedStepsNumber == Integer.parseInt(activity[indexOfDay].substring(13))) {
                return "The new value is the same as the old value";
            } else {
                activity[indexOfDay] = activity[indexOfDay].replace(activity[indexOfDay], rawDate + " - " + updatedStepsNumber);
            }
        }

        return "Activity successfully updated for " + formatedDate;
    }

    public static String displayMostActiveDay() {
        if (activity.length == 0) {
            return noActivityAddedYet;
        }

        int maximum = Integer.parseInt(activity[0].substring(13));
        String dayMaximumSteps = activity[0].substring(0, 10);

        for (int i = 0; i < activity.length; i++) {
            if (Integer.parseInt(activity[i].substring(13)) > maximum) {
                maximum = Integer.parseInt(activity[i].substring(13));
                dayMaximumSteps = activity[i].substring(0, 10);
            }
        }

        return "The most active day is " + Utilities.createFormattedDate(Integer.parseInt(dayMaximumSteps.substring(0, 4)),
                Integer.parseInt(dayMaximumSteps.substring(5, 7)), Integer.parseInt(dayMaximumSteps.substring(8, 10))) + " - " + maximum + " steps";
    }

    public static String displayLeastActiveDay() {
        if (activity.length == 0) {
            return noActivityAddedYet;
        }

        int minimum = Integer.parseInt(activity[0].substring(13));
        String dayMinimumSteps = activity[0].substring(0, 10);

        for (int i = 0; i < activity.length; i++) {
            if (Integer.parseInt(activity[i].substring(13)) < minimum) {
                minimum = Integer.parseInt(activity[i].substring(13));
                dayMinimumSteps = activity[i].substring(0, 10);
            }
        }

        return "The most active day is " + Utilities.createFormattedDate(Integer.parseInt(dayMinimumSteps.substring(0, 4)),
                Integer.parseInt(dayMinimumSteps.substring(5, 7)), Integer.parseInt(dayMinimumSteps.substring(8, 10))) + " - " + minimum + " steps";
    }

    public static String displayAverageStepsPerDay() {
        if (activity.length == 0) {
            return noActivityAddedYet;
        }

        int sum = 0;

        for (int i = 0; i < activity.length; i++) {
            sum = sum + Integer.parseInt(activity[i].substring(13));
        }

        return "The average steps per day is " + sum / activity.length + " steps";
    }
}
