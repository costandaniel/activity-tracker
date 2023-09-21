package ro.scoalainformala.business;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    public static void addNewStepsPerDay(ArrayList<Integer> steps, ArrayList<String> days) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of steps u want to add: ");
        int stepsRead = Integer.valueOf(scanner.nextLine());
        System.out.println("Please enter the day that the steps were made: ");
        String day = scanner.nextLine();
        steps.add(stepsRead);
        days.add(day);
        System.out.println("Thanks for adding! Good bye!");
    }

    public static void listAllSteps(ArrayList<Integer> steps,ArrayList<String> days) {
        for (int i = 0;i<=steps.size() -1 ;i++){
            System.out.println(steps.get(i) + " - " + days.get(i));
        }
    }

    public static void displayStepsForAGivenDay(ArrayList<Integer> steps, ArrayList<String> days) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please specify the day: ");
        String day = scanner.nextLine();
        if (days.contains(day)) {
            int index = days.indexOf(day);
            if (index != -1) {
                System.out.println(steps.get(index));
            } else {
                System.out.println("Day not found!!");
            }

        }
    }
    public static void updateStepsForAGivenDay(ArrayList<Integer> steps, ArrayList<String> days) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please specify the day: ");
        String day = scanner.nextLine();
        System.out.println("Please specify the number of steps u want modified:");
        int step = scanner.nextInt();
        if (days.contains(day)) {
            int index = days.indexOf(day);
            if (index != -1) {
                steps.set(index,step);
                System.out.println("Steps we're updated, have a great day! ");
            } else {
                System.out.println("Day not found!!");
            }

        }
    }
    public static void theMostActiveDay(ArrayList<Integer> steps, ArrayList<String> days){
        int mostActive = steps.get(0);
        int index = 0;
        for(int step:steps) {
            if(step >= mostActive){
                mostActive = step;
                index = steps.indexOf(step);
            }
        }
        System.out.println("The most active day had " + mostActive + " at the date: " + days.get(index));

    }
    public static void theLeastActiveDay(ArrayList<Integer> steps, ArrayList<String> days){
        int leastActive = steps.get(0);
        int index = 0;
        for(int step:steps) {
            if(step <= leastActive){
                leastActive = step;
                index = steps.indexOf(step);
            }
        }
        System.out.println("The least active day had " + leastActive + " at the date: " + days.get(index));

    }
    public static void averageSteps(ArrayList<Integer> steps){
        int sum = 0;
        for(int step:steps){
            sum+=step;
        }
        System.out.println(sum*1.0/steps.size());
    }
}

