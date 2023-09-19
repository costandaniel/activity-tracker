package ro.scoalainformala.business;

import java.util.Scanner;

public class Service {


    private static String[][] activities = new String[5][2];
    private static int activityCount = 0;

    public static String addNewActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add date: ");
        String date = scanner.nextLine();
        activities[activityCount][0] = date;
        System.out.print("Add number of steps: ");
        String steps = scanner.nextLine();
        activities[activityCount][1] = steps;
        activityCount++;
        return "Activity added successfully";
    }

    public static String listAllDays() {
        String days = "";
        for (int i = 0; i < activities.length; i++) {
            days = days + (activities[i][0]) + "\n";
        }
        return "The days are: " + "\n" + days;
    }

    public static String listStepsForAGivenDay() {
        int i = 0;
        String steps = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a date: ");
        String date = scanner.nextLine();

        while (i <= activities.length) {
            try {
                if (activities[i][0].equals(date)) {
                    steps = steps + (activities[i][1]);
                    break;
                }
            } catch (Exception e) {
                return "The date doesn't exist";
            }
            i++;
        }
        return "The steps for the selected day are: " + steps;
    }

    public static String updateStepsForADay() {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the date you want to update: ");
        String date = scanner.nextLine();
        while (i <= activities.length) {
            try {
                if (activities[i][0].equals(date)) {
                    System.out.println("Enter new steps value: ");
                    String steps = scanner.nextLine();
                    activities[i][1] = steps;
                    break;
                } else if (!activities[i][0].equals(date)) {
                    i++;
                }
            } catch (Exception e) {
                return "The date you want to update doesn't exist";
            }
        }
        return "Date updated successfully";
    }

    public static String mostActiveDay() {
        int maxSteps = 0;
        String mostActiveDay = null;
        for (int i = 0; i < activities.length; i++) {
            String day = activities[i][0];
            String steps = activities[i][1];
            if (steps != null && !steps.isEmpty()) {
                int stepsInt = Integer.parseInt(steps);
                if (maxSteps < stepsInt) {
                    maxSteps = stepsInt;
                    mostActiveDay = day;
                }
            }
        }
        return "The most active day is: " + mostActiveDay;
    }

    public static String leastActiveDay() {
        int minSteps = 2147483647;
        String leastActiveDay = null;
        for (int i = 0; i < activities.length; i++) {
            String day = activities[i][0];
            String steps = activities[i][1];
            if (steps != null && !steps.isEmpty()) {
                int stepsInt = Integer.parseInt(steps);
                if (minSteps > stepsInt) {
                    minSteps = stepsInt;
                    leastActiveDay = day;
                }
            }
        }
        return "The least active day is: " + leastActiveDay;
    }

    public static String averageStepsPerDays() {
        int totalSteps = 0;
        int counter = 0;

        for (int i = 0; i < activities.length; i++) {
            if (activities[i][1] != null) {
                int stepsInt = Integer.parseInt(activities[i][1]);
                totalSteps = totalSteps + stepsInt;
                counter++;
            }
        }

        try {
            int average = totalSteps / counter;
            String averageString = Integer.toString(average);
            return "The average is: " + averageString;
        } catch (Exception e) {
            return "Can't divide by 0";
        }
    }
}
