package ro.scoalainformala.utilities;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Utilities {

    public static String createFormattedDate(int year, int month, int day) {
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }
        if (month > LocalDate.now().getMonthValue() || month < 1) {
            return "Invalid month";
        }
        if (day < 1) {
            return "Invalid day";
        } else if (day > YearMonth.of(year, month).lengthOfMonth() || (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth())) {
            return "Invalid day";
        }

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public static String concatenateDaySteps(String[] activity) {
        String concatenated = "";
        String[] formatedDates = new String[activity.length];
        int[] steps = new int[activity.length];
        for (int i = 0; i < activity.length; i++) {
            formatedDates[i] = createFormattedDate(Integer.parseInt(activity[i].substring(0, 4)),
                    Integer.parseInt(activity[i].substring(5, 7)), Integer.parseInt(activity[i].substring(8, 10)));
            steps[i] = Integer.parseInt(activity[i].substring(13));
            if (steps[i] == 1) {
                concatenated = concatenated + formatedDates[i] + " - " + steps[i] + " step" + "\n";
            } else {
                concatenated = concatenated + formatedDates[i] + " - " + steps[i] + " steps" + "\n";
            }
        }

        return concatenated;
    }

    public static int stringBinarySearch(String[] activity, String stringToFind) {
        int lowIndex = 0;
        int highIndex = activity.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (stringToFind.compareTo(activity[middleIndex]) == 0) {
                return middleIndex;
            }

            if (stringToFind.compareTo(activity[middleIndex]) > 0) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    public static String[] createActivityArray(String[] array, int year, int month, int day, int numberOfSteps) {
        String[] activity = new String[array.length + 1];
        LocalDate localDate = LocalDate.of(year, month, day);

        if (array.length == 0) {
            activity[0] = localDate + " - " + numberOfSteps;
            return activity;
        } else {
            for (int i = 0; i < array.length; i++) {
                activity[i] = array[i];
            }
            activity[array.length] = localDate + " - " + numberOfSteps;
            return activity;
        }
    }

    public static String[] copyPopulateArray(String[] arrayToBeCopied) {
        String[] copy = Arrays.copyOf(arrayToBeCopied, arrayToBeCopied.length);

        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].substring(0, 10);
        }

        return copy;
    }

}
