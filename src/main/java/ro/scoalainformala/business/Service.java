package ro.scoalainformala.business;

import ro.scoalainformala.utilities.Utilities;

import java.time.Year;
import java.util.Scanner;

public class Service {

    static Scanner scanner = new Scanner(System.in);
    int[] steps = new int[365];
    String[] days = new String[365];

    public static String addNewActivity() {

        System.out.print("Add number of steps: ");
        int numberOfSteps = scanner.nextInt();

        System.out.print("Add new date (yyyy-MM-dd): ");
        String date = scanner.next();

        String newDate = Utilities.formatDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
        System.out.println();

        return "Activity successfully added for " + newDate;
    }
}
