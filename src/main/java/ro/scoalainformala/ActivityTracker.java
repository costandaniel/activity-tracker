package ro.scoalainformala;

import ro.scoalainformala.business.Service;
import ro.scoalainformala.menu.Menu;

import java.util.Scanner;

public class ActivityTracker {

    // test -- fail
    //static String[] day = new String[100];
    //public static int[] step = new int[100];
    //public static int k = 0; //number of reccords added

    public static void main(String[] args) {

        //test only
        //Service.test(); // 5 records initialization

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println(Menu.createMenu());
            option = scanner.nextInt();
            // switch expression
            String result = switch (option) {
                case 1 -> Service.addNewActivity();
                case 2 -> Service.listActivity();
                case 3 -> Service.displayDay();
                case 4 -> Service.updateSteps();
                case 5 -> Service.mostActiveDay();
                case 6 -> Service.leastActiveDay();
                case 7 -> Service.averageSteps();
                case 8 -> "Goodbye!";
                default -> "Invalid option";
            };
            System.out.println(result);
        } while (option != 8);
    }
}
