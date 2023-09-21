package ro.scoalainformala.business;

import java.util.Scanner;

public class  Service {

    static String[] days = new String[20];
    static int[] steps = new int[20];
    static int c = 0;
    public static String addNewActivity() {
        // TODO implement add functionality
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the day in \"YY-MM-DD\" format: ");
        String newDay = sc.next();
        System.out.print("Please enter the number of steps: ");
        int daySteps = sc.nextInt();
        days[c] = newDay;
        steps[c] = daySteps;
        c++;
        return "Activity added";
    }

    public static String listAllDays() {
       for (int i = 0; i < c; i++) {
           System.out.println("For the day: " + days[i] + " the steps registered are: " + steps[i]);
       }
        return "All days listed";
    }
    public static String displayStepsForGivenDay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the day for wich you want the steps to be displayed: ");
        String day = sc.next();

        int low = 0;
        int high = c;
        int item = Integer.parseInt(day.replace("-", ""));
        int poz = -1;

        while(low <= high ) {
            int mid = (low + high) / 2;
            int guess = Integer.parseInt(days[mid].replace("-",""));
            if( guess == item ) {
                poz = mid;
            }
            if( guess > item ) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if ( poz == -1) {
            System.out.print(" Invalid day ");
        }
        System.out.println("For the day: " + day + " the steps registered are: " + steps[poz]);

        return "Steps displayd for the given day";
    }
}
