package ro.scoalainformala.utilities;

import java.time.LocalDate;
import java.time.Year;

public class Utilities {

    public static String formatDate(int year, int month, int day) {
        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        String invalidDay = "Invalid day";

        if (month > LocalDate.now().getMonthValue() || month == 0) {
            return "Invalid month";
        } else if (month == LocalDate.now().getMonthValue() && day > LocalDate.now().getDayOfMonth()) {
            return invalidDay;
        }

        String newMonth = switch (month) {
            case 1 -> "Jan";
            case 2 -> "Feb";
            case 3 -> "Mar";
            case 4 -> "Apr";
            case 5 -> "May";
            case 6 -> "Jun";
            case 7 -> "Jul";
            case 8 -> "Aug";
            case 9 -> "Sep";
            case 10 -> "Oct";
            case 11 -> "Nov";
            case 12 -> "Dec";
            default -> "Invalid month";
        };

        if (day < 1) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Jan") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Mar") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Apr") && day > 30) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("May") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Jun") && day > 30) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Jul") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Aug") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Sep") && day > 30) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Oct") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Nov") && day > 30) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Dec") && day > 31) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Feb") && year / 4 == 0 && day > 29) {
            System.out.println(invalidDay);
        } else if (newMonth.equals("Feb") && year / 4 != 0 && day > 28) {
            System.out.println(invalidDay);
        }

        return newMonth + " " + day + ", " + year;
    }

    public static String getDate(String date) {
        if (date.substring(0, 4).contains("-") || date.substring(5, 7).contains("-") || date.substring(8, 10).contains("-") || Integer.parseInt(date.substring(8, 10)) == 0) {
            return "Invalid date input";
        }
        return formatDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
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

    public static String[] addStringArray(String[] firstArray, String elementToAdd) {
        String[] newArray = new String[firstArray.length + 1];

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
                concatenated = concatenated + days[i] + " - " + steps[i] + " steps";
            } else {
                concatenated = concatenated + days[i] + " - " + steps[i] + " steps" + ", " + "\n";
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

}
