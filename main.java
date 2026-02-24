/*
Names: Anisa Ramos, Zoe Berge, MorganAshli Harper, David Pleban
Professor: Dr. Yacobellis
Comp 170
Date: 12/3/23
 */

import java.util.Scanner;

public class Main {
    // Constants defining the structure of the game

    // Number of categories in the Jeopardy game
    private static final int NUM_CATEGORIES = 5;

    // Number of questions per category in the Jeopardy game
    private static final int NUM_QUESTIONS_PER_CATEGORY = 5;

    private static String[][] categories = {
            {"Loops",
                    //question 1
                    "100 points: What are the three types of loops?" +
                            "\n A. For loop, else/if, while loop." +
                            "\n B. Else /if,  for loop, nested loop." +
                            "\n C. for loop, the while loop, and do loop." +
                            "\n Hint: Is if/else a loop? \n ",
                    //question 2
                    "200 points: True or False: A loop is a control structure that allows a set of instructions to be executed repeatedly. \n ",
                    //question 3
                    "300 points: True or False: In Java, the \"do-while\" loop always executes its body at least once, regardless of the initial condition.\n",
                    //question 4
                    "400 points: You have a task to calculate the sum of all even numbers between 1 and 10 (inclusive) using a loop. Which of the following loop constructs would be most suitable for this task?:" +
                            "\n A) for (int i = 1; i <= 10; i++)" +
                            "\n B) while (num <= 10)" +
                            "\n C) do { /* code */ } while (num <= 10)" +
                            "\n D) for (int i = 2; i <= 10; i += 2)\n"},
            {"Arrays",
                    //question 1
                    "100 points: True or False: Is a data structure that can store a fixed size sequence of elements of the same data type.\n",
                    //question 2
                    "200 points: Which of the following choices is the correct syntax for declaring/initializing an array of ten integers?" +
                            "\n A. Int [] a = new int [10]; " +
                            "\n B. Int [10] a = new int [10]; " +
                            "\n C. Int a[10]; " +
                            "\n D. [] int a = [10] int \n ",
                    //question 3
                    "300 points: Which of the following choices is the correct syntax for quickly declaring/initializing an array of six integers to store a certain list of values?" +
                            "\n A. Int[] a = { 17, -3, 42, 5, 9, 28}; " +
                            "\n B. Int [6] a = {17, -3, 42, 5, 9, 28};" +
                            "\n C. Int a { 17, -3. 42, 5, 9, 28};" +
                            "\n D. Int[] a = new int[6] {17, -3, 42, 5, 9, 28}; \n ",
                    //question 4
                    "400 points: You have an array of numbers of length n containing positive integers. You need to find the maximum product of two distinct elements in the array. Which of the following options represents the correct algorithm to achieve this efficiently?" +
                            "\n a. Sort the array in ascending order and return the product of the last two elements." +
                            "\n b. Initialize two variables, max and secondMax, to store the maximum and second maximum values in the array. Iterate through the array once, updating max and secondMax accordingly, and return the product of max and secondMax." +
                            "\n c. Use two nested loops to iterate through all pairs of elements in the array and find the maximum product." +
                            "\n d.  Create a HashSet to store unique elements in the array. Iterate through the array, and for each element, check its product with all other unique elements in the HashSet.\n"},
            {"Parameters",
                    //question 1
                    "100 points: Which of the following is the correct syntax for a method header with parameters?" +
                            "\n A. Public static void example(int x, y){ " +
                            "\n B.Public static(int x, int y) example() { " +
                            "\n C. Public static void example(int x, int y) { " +
                            "\n D. Public static void example(int y, int x,){ \n ",
                    //question 2
                    "200 points: The System.out.println command works on many different types of values, including ints and doubles. What is the term for such a method?" +
                            "\n A. Overwrite " +
                            "\n B. Override " +
                            "\n C. Overrate" +
                            "\n D. Overload \n ",
                    //question 3
                    "300 points: In Java, what is the difference between pass-by-value and pass-by-reference?\n" +
                            "\n A. Pass-by-value means passing the actual value of a variable to a method, while pass-by-reference means passing a reference to the memory location of the variable. " +
                            "\n B. Pass-by-value means passing a reference to the memory location of a variable, while pass-by-reference means passing the actual value of a variable. " +
                            "\n C. Pass-by-value and pass-by-reference are two terms that are used interchangeably in Java." +
                            "\n D. Java only supports pass-by-reference, and pass-by-value is not applicable.\n",
                    //question 4
                    "400 points: This method is called printStrings that accepts a String and a number of repetitions as parameters and prints that String the given number of times. For example the call:" +
                            "\n printStrings(â€œabcâ€ , 5) \" +\n" +
                            "\n Is this program true or false, following the output:" +
                            "\n Public static void printStrings(String input, int repetition){\n" +
                            "\t \t for (int i = 1; i < repetition; i++){\n" +
                            "\t \t \t System.out.println(input); \n" +
                            "}\n" +
                            "\t\t\tSystem.out.println(); \n" +
                            "\t}\n" +
                            "}\n"
            },
            {"Scanner",
                    "100 points: Which package needs to be imported to use the â€˜Scanner class in a java program?" +
                            "\n A. java.util.Scanner " +
                            "\n B.java.util.Scan " +
                            "\n C.Java.Scanner " +
                            "\n D. Java.until.Scanner\n",
                    "200 points: True or False: In Java, the Scanner class's nextLine() method can throw NoSuchElementException and IllegalStateException under certain circumstances, and handling these exceptions is crucial for robust input processing.\n",
                    "300 points: How can you check if the Scanner object inputScanner has a next integer input?\n" +
                            "a. inputScanner.hasNextInteger()\n" +
                            "b. inputScanner.hasNextInt()\n" +
                            "c. inputScanner.hasNextNumber()\n" +
                            "d. inputScanner.hasInteger()\n",
                    "400 points: What happens if you attempt to close a Scanner object (inputScanner) twice in Java?\n" +
                            "a. The compiler will throw an error, indicating that the Scanner object cannot be closed twice.\n" +
                            "b. The Scanner object will be closed without any issues.\n" +
                            "c. The first close() call will succeed, but the second one will throw an IllegalStateException.\n" +
                            "d. Both close() calls will succeed, and there won't be any issues.\n"}
    }; //end of categories

    // 2D array to store point values for each question
    private static int[][] pointValues = {
            {0, 100, 200, 300, 400},
            {0, 100, 200, 300, 400},
            {0, 100, 200, 300, 400},
            {0, 100, 200, 300, 400}
    };// end of pointValues

    // Player's score
    private static int UserScore = 0;

    // 2D array to track the status of each question (answered or not)
    private static boolean[][] questionStatus = new boolean[NUM_CATEGORIES][NUM_QUESTIONS_PER_CATEGORY];

    // 2D array to store user answers for each question
    private static String[][] userAnswers = new String[NUM_CATEGORIES][NUM_QUESTIONS_PER_CATEGORY];

    // 2D array to store correct answers for each question
    private static String[][] correctAnswers = {
            {"", "C", "True", "True", "D"},
            {"", "True", "A", "A", "B"},
            {"", "C", "D", "A", "False"},
            {"", "A", "True", "B", "C"}
    };// end of correctAnswers

    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the game introduction and rules
        introduction();

        int attempts = 0;

        while (true) {
            // Display the game board
            displayBoard();

            // Prompt the user to choose a category
            System.out.print("Choose your Category: ");
            int category = scanner.nextInt();

            // Prompt the user to choose a range value for the selected category
            System.out.print("Chose the question you want (1-4) : ");
            int question = scanner.nextInt();


            // Validate the user's input
            if (category < 0 || category > NUM_CATEGORIES || question < 0 || question > NUM_QUESTIONS_PER_CATEGORY) {
                System.out.println("Invalid category or question number. Please try again.");
                continue;
            }// end of if statement

            // Check if the question has already been answered
            if (questionStatus[category][question]) {
                System.out.println("This question has already been answered, choose another question.");
                continue;
            }// end of if statement

            // Ask the user the selected question
            askUserQuestions(category, question, scanner);

            // Display the user's current score
            displayScore();

            //if statement for is the user achieves 1000 points they win the game,
            if (UserScore >= 1000) {
                System.out.println("Congratulations you've reached 1000 points! You have won the game! Good Work!");
                break;
            }

            //adds an attempt counter after every question
            attempts++;

            //if statement for is the user does 6 attempt the game is over.
            if (attempts >= 6) {
                System.out.println("You have reached the max amount of attempts allowed. Game Over!");
                break;
            }

            // Ask the user if they want to continue playing or cash out
            System.out.print("Would you like to continue playing or end the game? (Yes/No): ");
            String playAgain = scanner.next();

            // If the user chooses to cash out, exit the game loop
            if (playAgain.equalsIgnoreCase("No")) {
                break;
            }// end of if statement
        }// end of while loop

        // Display the user's final score
        System.out.println("Your final score is: $" + UserScore);

        // Close the scanner
        scanner.close();
    }// end of main

    // Method to display the game introduction
    public static void introduction() {
        //Welcomes user to the game, as the rules are then implemented
        System.out.println(" Welcome to Java Jeopardy!");
        System.out.println();
        System.out.println(" To play the game, please type the topic you would like to choose.\n" +
                " Press 'enter' from the numbers that corresponds with the category.\n" +
                " Then, type point number you would like that ranges from the questions\n" +
                " difficulty. Hence, 1 is 100 points (easiest), 2 is 200 points, 3 is\n" +
                " 300 points, and 4 is 400 points (hardest), and press 'enter'. You will\n" +
                " be prompted with a question, which you will answer to the best of your\n" +
                " abilities. If you are correct, you gain points, but if you are incorrect\n" +
                " you lose points. Try and see how many points you can get!\n" +
                " But be careful you only have six attempts to get to 1000 points, so choose your questions carefully!");
        System.out.println();
        System.out.println(" Good Luck! ");
    }// end of introduction

    // Method to display the game board
    public static void displayBoard() {
        String[] categories = {"0: Loops    ", "1: Arrays      ", "2: Parameters", "3: Scanner  "};
        System.out.println();

        for (int i = 0; i < pointValues.length; i++) {
            System.out.print(categories[i] + "\t");
            for (int x = 1; x < pointValues[i].length; x++) {
                System.out.print("| " + pointValues[i][x] + " |" + "\t");
            }// end of for loop
            System.out.println();
        }// end of for loop
    }// end of displayBoard

    // Method to ask the user a question
    public static void askUserQuestions(int category, int questionIndex, Scanner scanner) {
        System.out.println(categories[category][questionIndex]);
        System.out.print("Your Answer: ");
        String userAnswer = scanner.next();

        // Initialize correctAnswer
        String correctAnswer = "";

        // Ensure that the correctAnswer is assigned based on valid indices
        if (category >= 0 && category < correctAnswers.length && questionIndex >= 0 && questionIndex < correctAnswers[category].length) {
            correctAnswer = correctAnswers[category][questionIndex];
        } else {
            // Handle the case where indices are out of bounds
            throw new IllegalArgumentException("Invalid category or question index.");
        }// end of else statement

        // Check if the user's answer is correct
        if (userAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            System.out.println("Correct! You've earned $" + pointValues[category][questionIndex]);
            UserScore += pointValues[category][questionIndex];
        } else {
            System.out.println("Incorrect! The correct answer is " + correctAnswer);
            int penaltyPoints = pointValues[category][questionIndex];
            UserScore -= penaltyPoints;
        }//  end of else statement

        // Store the user's answer
        userAnswers[category][questionIndex] = userAnswer;

        // Mark the question as answered
        questionStatus[category][questionIndex] = true;
    }// askUserQuestions(int category, int questionIndex, Scanner scanner)

    // Method to display the user's current score
    public static void displayScore() {
        System.out.println("Your current total score is: $" + UserScore);
    }// displayScore()
}// end of JavaJeopardy
