package ro.scoalainformala.business;

import java.util.Scanner;

//import ro.scoalainformala.ActivityTracker;

public class Service {

    static String[] day = new String[100];
    static int[] step = new int[100];
    static int k = 0; //number of reccords added


    //test only - 5 records initialization
    /*
    public static void test() {
        day[0] = "2023-01-01";
        step[0] = 1111;
        day[1] = "2023-02-02";
        step[1] = 1222;
        day[2] = "2023-03-03";
        step[2] = 1333;
        day[3] = "2023-04-04";
        step[3] = 1444;
        day[4] = "2023-05-05";
        step[4] = 1555;
        k = 5;
    }
    */

    public static String addNewActivity() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter new day e.g. \"2022-11-23\" for Nov. 23, 2022: ");
        String newDay = s.next();
        day[k] = newDay;
        System.out.print("\nEnter number of steps \"ex: 588\": ");
        int newStep = s.nextInt();
        step[k] = newStep;
        k++;

        return "Activity added\n";
    }

    public static String listActivity() {
        int i = 0;
        if (k > 0) {
            for (i = 0; i < k; i++) {
                System.out.println("Day: " + day[i] + "  Steps: " + step[i]);
            }
        }
        return "Activities listed\n";
    }

    public static String displayDay() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the day to display the number of steps: ");
        String dayx = s.next();

        int low = 0;
        int high = k;
        int item = Integer.parseInt(dayx.replace("-", ""));
        int poz = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = Integer.parseInt(day[mid].replace("-", ""));
            if (guess == item) {
                poz = mid;
                break;
            }

            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (poz == -1) {
            return "The day does not exixts!\n";
        }
        return "The number of steps for the day " + dayx + " are: " + step[poz] + "\n";
    }

    public static String updateSteps() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the day to update the number of steps: ");
        String dayx = s.next();
        System.out.print("Enter the new number of steps: ");
        int newSteps = s.nextInt();

        int low = 0;
        int high = k;
        int item = Integer.parseInt(dayx.replace("-", ""));
        int poz = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = Integer.parseInt(day[mid].replace("-", ""));
            if (guess == item) {
                poz = mid;
                break;
            }

            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (poz == -1) {
            return "The day does not exixts!\n";
        }
        step[poz] = newSteps;
        return "The number of steps for the day " + dayx + " have been updated to " + newSteps + "\n";
    }

    public static String mostActiveDay() {
        int i = 0;
        int imax = 0; //index with moust steps
        int max = step[0];

        for (i = 1; i < k; i++) {
            if (step[i] > max) {
                max = step[i];
                imax = i;
            }
        }
        return "The day with moust steps(" + step[imax] + ") is " + day[imax] + "\n";
    }

    public static String leastActiveDay() {
        int i = 0;
        int imin = 0; //index with least steps
        int min = step[0];

        for (i = 1; i < k; i++) {
            if (step[i] < min) {
                min = step[i];
                imin = i;
            }
        }
        return "The day with least steps(" + step[imin] + ") is " + day[imin] + "\n";
    }

    public static String averageSteps() {
        float averageStep = 0;
        for (int i = 0; i < k; i++) {
            averageStep = averageStep + step[i];
        }
        averageStep = averageStep / k;
        return "The average steps per day are: " + averageStep + "\n";
    }

}
