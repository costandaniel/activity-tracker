package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);
    static String invalid = "Invalid";
    static String noActivityAddedYet = "No activity added yet";
    static String[] dates = {};

    public static String addNewActivity() {
        System.out.println("Add new date:");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        System.out.print("Month: ");
        int month = scanner.nextInt();
        if (month > LocalDate.now().getMonthValue() || month == 0) {
            return "Invalid month";
        }

        System.out.print("Day: ");
        int day = scanner.nextInt();
        if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return "Invalid day";
        }
        if (day < 1) {
            return "Invalid day";
        } else if (day > YearMonth.of(year, month).lengthOfMonth()) {
            return "Invalid day";
        }

        LocalDate notFormattedDate = LocalDate.of(year, month, day);
        String date = Utilities.createDate(year, month, day);
        String[] copy = Arrays.copyOf(dates, dates.length);

        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].substring(0, 10);
        }

        int indexOfDay = Utilities.stringBinarySearch(copy, notFormattedDate.toString());
        int numberOfSteps;

        if (date.contains(invalid)) {
            return date;
        } else {
            if (indexOfDay != -1) {
                return date + " already exists";
            } else {
                System.out.print("Add number of steps: ");
                if (scanner.hasNextInt()) {
                    numberOfSteps = scanner.nextInt();
                    dates = Utilities.makeDateArray(dates, year, month, day, numberOfSteps);
                } else {
                    return "Invalid steps input";
                }
            }
        }

        Arrays.sort(dates);
        return "Activity successfully added for " + date;
    }

    public static String listAllDays() {
        if (dates.length == 0) {
            return noActivityAddedYet;
        }

        return Utilities.concatenateDaySteps(dates);
    }

    public static String displayStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        System.out.print("Month: ");
        int month = scanner.nextInt();
        if (month > LocalDate.now().getMonthValue() || month == 0) {
            return "Invalid month";
        }

        System.out.print("Day: ");
        int day = scanner.nextInt();
        if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return "Invalid day";
        }
        if (day < 1) {
            return "Invalid day";
        } else if (day > YearMonth.of(year, month).lengthOfMonth()) {
            return "Invalid day";
        }

        LocalDate notFormattedDate = LocalDate.of(year, month, day);
        String date = Utilities.createDate(year, month, day);
        String[] copy = Arrays.copyOf(dates, dates.length);
        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].substring(0, 10);
        }

        int indexOfDay = Utilities.stringBinarySearch(copy, notFormattedDate.toString());

        if (date.contains(invalid)) {
            return date;
        } else {
            if (indexOfDay == -1) {
                return date + " does not exist";
            }
        }

        return "The number of steps for " + date + " is " + dates[indexOfDay].substring(13);
    }

    public static String updateStepsForDay() {
        System.out.println("Desired date: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        System.out.print("Month: ");
        int month = scanner.nextInt();
        if (month > LocalDate.now().getMonthValue() || month == 0) {
            return "Invalid month";
        }

        System.out.print("Day: ");
        int day = scanner.nextInt();
        if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return "Invalid day";
        }
        if (day < 1) {
            return "Invalid day";
        } else if (day > YearMonth.of(year, month).lengthOfMonth()) {
            return "Invalid day";
        }

        LocalDate notFormattedDate = LocalDate.of(year, month, day);
        String date = Utilities.createDate(year, month, day);
        String[] copy = Arrays.copyOf(dates, dates.length);
        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].substring(0, 10);
        }

        int indexOfDay = Utilities.stringBinarySearch(copy, notFormattedDate.toString());

        if (date.contains(invalid)) {
            return date;
        } else {
            if (indexOfDay == -1) {
                return date + " does not exist";
            }
            System.out.print("Type the updated number of steps: ");
            int updatedStepsNumber = scanner.nextInt();

            if (updatedStepsNumber == Integer.parseInt(dates[indexOfDay].substring(13))) {
                return "The new value is the same as the old value";
            } else {
                dates[indexOfDay] = dates[indexOfDay].replace(dates[indexOfDay], notFormattedDate + " - " + updatedStepsNumber);
            }
        }

        return "Activity successfully updated for " + date;
    }

    public static String displayMostActiveDay() {
        if (dates.length == 0) {
            return noActivityAddedYet;
        }

        int maximum = Integer.parseInt(dates[0].substring(13));
        String dayMaximumSteps = dates[0].substring(0, 10);
        ;
        for (int i = 0; i < dates.length; i++) {
            if (Integer.parseInt(dates[i].substring(13)) > maximum) {
                maximum = Integer.parseInt(dates[i].substring(13));
                dayMaximumSteps = dates[i].substring(0, 10);
            }
        }

        LocalDate formattedDate =
                LocalDate.of(Integer.parseInt(dayMaximumSteps.substring(0, 4)), Integer.parseInt(dayMaximumSteps.substring(5, 7)), Integer.parseInt(dayMaximumSteps.substring(8, 10)));
        return "The most active day is " + formattedDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")) + " - " + maximum + " steps";
    }

    public static String displayLeastActiveDay() {
        if (dates.length == 0) {
            return noActivityAddedYet;
        }

        int minimum = Integer.parseInt(dates[0].substring(13));
        String dayMinimumSteps = dates[0].substring(0, 10);
        ;
        for (int i = 0; i < dates.length; i++) {
            if (Integer.parseInt(dates[i].substring(13)) < minimum) {
                minimum = Integer.parseInt(dates[i].substring(13));
                dayMinimumSteps = dates[i].substring(0, 10);
            }
        }

        LocalDate formattedDate =
                LocalDate.of(Integer.parseInt(dayMinimumSteps.substring(0, 4)), Integer.parseInt(dayMinimumSteps.substring(5, 7)), Integer.parseInt(dayMinimumSteps.substring(8, 10)));
        return "The least active day is " + formattedDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")) + " - " + minimum + " steps";
    }

    public static String displayAverageStepsPerDay() {
        if (dates.length == 0) {
            return noActivityAddedYet;
        }

        int sum = 0;

        for (int i = 0; i < dates.length; i++) {
            sum = sum + Integer.parseInt(dates[i].substring(13));
        }

        return "The average steps per day is " + sum / dates.length + " steps";
    }
}
