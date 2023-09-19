package ro.scoalainformala.menu;

public class Menu {

    public static String createMenu() {
        return """
        Welcome to Fitness Tracker
                        
        1 Add steps for a new day
        2 List all days
        3 Display steps for a given day
        4 Update steps for given day
        5 Display most active day
        6 Display least active day
        7 Display average steps per day
        8 Exit
                        
        Please select one of the available options ( 1 - 8 ):
        """;
    }
}



