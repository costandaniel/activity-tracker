package ro.scoalainformala.utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Utilities {

    public static String createDate(int year, int month, int day) {
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        String invalidDay = "Invalid day";

        if (month > LocalDate.now().getMonthValue() || month == 0) {
            return "Invalid month";
        } else if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return invalidDay;
        }

        if (day < 1) {
            return invalidDay;
        } else if (day > YearMonth.of(year, month).lengthOfMonth()) {
            return invalidDay;
        }

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public static int[] addIntArray(int[] firstArray, int elementToAdd) {
        int[] newArray = new int[firstArray.length + 1];

        if (firstArray.length == 0) {
            newArray[0] = elementToAdd;
            return newArray;
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                newArray[i] = firstArray[i];
            }
            newArray[firstArray.length] = elementToAdd;
            return newArray;
        }

    }

    public static String concatenateDaySteps(String[] days, int[] steps) {
        String concatenated = "";
        for (int i = 0; i < days.length; i++) {
            if (i == days.length - 1) {
                if (steps[i] == 1) {
                    concatenated = concatenated + days[i] + " - " + steps[i] + " step";
                } else {
                    concatenated = concatenated + days[i] + " - " + steps[i] + " steps";
                }
            } else {
                if (steps[i] == 1) {
                    concatenated = concatenated + days[i] + " - " + steps[i] + " step" + ", " + "\n";
                } else {
                    concatenated = concatenated + days[i] + " - " + steps[i] + " steps" + ", " + "\n";
                }
            }
        }

        return concatenated;
    }

    public static int stringBinarySearch(String[] daysStepsArray, String stringToFind) {
        int lowIndex = 0;
        int highIndex = daysStepsArray.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (stringToFind.compareTo(daysStepsArray[middleIndex]) == 0) {
                return middleIndex;
            }

            if (stringToFind.compareTo(daysStepsArray[middleIndex]) > 0) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    public static LocalDate[] makeDateArray(LocalDate[] array, int year, int month, int day) {
        LocalDate[] dateArray = new LocalDate[array.length + 1];
        LocalDate localDate = LocalDate.of(year, month, day);

        if (array.length == 0) {
            dateArray[0] = localDate;
            return dateArray;
        } else {
            for (int i = 0; i < array.length; i++) {
                dateArray[i] = array[i];
            }
            dateArray[array.length] = localDate;
            return dateArray;
        }
    }

    public static String[] formatDateArray(LocalDate[] dateArray) {
        String[] days = new String[dateArray.length];
        for (int i = 0; i < dateArray.length; i++) {
            days[i] = dateArray[i].format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        }

        return days;
    }

    public static String[] addStringArray(String[] array, String elementToAdd) {
        String[] newArray = new String[array.length + 1];
        if (array.length == 0) {
            newArray[0] = elementToAdd;
            return newArray;
        } else {
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
        }
        newArray[array.length] = elementToAdd;
        return newArray;
    }

}
