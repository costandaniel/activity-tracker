package ro.scoalainformala.utilities;

import ro.scoalainformala.business.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

public class Utilities {

    public static String formatDate(int year, int month, int day) {

        if (year < Year.now().getValue() - 2 || year > Year.now().getValue()) {
            return "Invalid year";
        }

        if (month > LocalDate.now().getMonthValue() || day > LocalDate.now().getDayOfMonth()) {
            return "Invalid month or day";
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
            System.out.println("Invalid day");
        } else if (newMonth.equals("Jan") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Mar") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Apr") && day > 30) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("May") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Jun") && day > 30) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Jul") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Aug") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Sep") && day > 30) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Oct") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Nov") && day > 30) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Dec") && day > 31) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Feb") && year / 4 == 0 && day > 29) {
            System.out.println("Invalid day");
        } else if (newMonth.equals("Feb") && year / 4 != 0 && day > 28) {
            System.out.println("Invalid day");
        }

        return newMonth + " " + day + ", " + year;
    }

}
