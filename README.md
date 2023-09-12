# Activity Tracker

Create a program which simulates an activity tracker. The application is able to track the number of steps that you took
in any given day.

The state will not be preserved between program runs (we haven't learned about mechanisms which allow us to persist data
after the program stops).

The tracker is able to associate to a given day codified as a `String` value (e.g. "2022-11-23" for Nov. 23, 2022; e.g. "
2022-12-01" for Dec 1, 2022) a number of steps that you took that day. When you store data in the application, enter
dates chronologically. You will use binary search - you have to implement it as part of a utility class in your
project - to look for a specified date in the data structure.

## Requirements:

Create a user menu such as the following:

    Welcome to Fitness Tracker

    1 Add steps for a new day
    2 List all days
    3 Display steps for a given day
    4 Update steps for given day
    5 Display most active day
    6 Display least active day
    7 Display average steps per day
    8 Exit

    Please select one of the available options ( 1 - 8 )

The user menu will be displayed all over again after we're done with the chosen option. The program stops only after we
choose the Exit option.

Try to follow the __*Single Responsibility Principle*__ when designing your methods. Also, try to create methods which return
values - you’ll have to test these methods with unit tests. Delay printing to the console as much as possible. In fact,
reading input and printing out the results should be done only in the main method.