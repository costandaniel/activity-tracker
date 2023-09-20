package ro.scoalainformala.utilities;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static String createDate(int year, int month, int day) {
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }
        if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return "Invalid month";
        }
        if (day < 1) {
            return "Invalid day";
        } else if (day > YearMonth.of(year, month).lengthOfMonth()) {
            return "Invalid day";
        }

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public static String concatenateDaySteps(String[] days) {
        String concatenated = "";
        String[] formatedDates = new String[days.length];
        int[] steps = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            LocalDate localDate = LocalDate.of(Integer.parseInt(days[i].substring(0, 4)), Integer.parseInt(days[i].substring(5, 7)), Integer.parseInt(days[i].substring(8, 10)));
            formatedDates[i] = localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            steps[i] = Integer.parseInt(days[i].substring(13));
            if (steps[i] == 1) {
                concatenated = concatenated + formatedDates[i] + " - " + steps[i] + " step" + "\n";
            } else {
                concatenated = concatenated + formatedDates[i] + " - " + steps[i] + " steps" + "\n";
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

    public static String[] makeDateArray(String[] array, int year, int month, int day, int numberOfSteps) {
        String[] dateArray = new String[array.length + 1];
        LocalDate localDate = LocalDate.of(year, month, day);

        if (array.length == 0) {
            dateArray[0] = localDate + " - " + numberOfSteps;
            return dateArray;
        } else {
            for (int i = 0; i < array.length; i++) {
                dateArray[i] = array[i];
            }
            dateArray[array.length] = localDate + " - " + numberOfSteps;
            return dateArray;
        }
    }

}
