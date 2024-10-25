import java.util.Scanner;

public class SafeInput {
    //Scanner all method will use
    private static Scanner sc = new Scanner(System.in);

    //Part A: Get a non-zero length string
    public static String getNonZeroLenString(Scanner in,String prompt){
        String input = "";
        do{
            System.out.print(prompt);
            input = sc.nextLine();
        }
        while(input.trim().length() == 0);
        return input;
    }

    // Part B: Get an integer within a range
    public static int getInt(Scanner pipe,String prompt) {
        int input = 0;
        boolean valid = false;
        do {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!valid);
        return input;
    }



    // Part C: Get a floating-point number (double)
    public static double getDouble(Scanner pipe,String prompt) {
        double input = 0;
        boolean valid = false;
        do {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!valid);
        return input;
    }




    // Part D: get a ranged integer from the user

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInt = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            // Check if the input is an integer
            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();  // Get the integer input

                // Validate if it is within the range
                if (userInt >= low && userInt <= high) {
                    valid = true;  // Input is valid
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ". Try again.");
                }
            } else {
                // If not an integer, show an error and clear the invalid input
                System.out.println("Error: Invalid input. Please enter an integer.");
                pipe.nextLine();  // Clear the buffer
            }
        } while (!valid);  // Repeat until valid input is provided

        pipe.nextLine();  // Clear any remaining newline character in the buffer
        return userInt;  // Return the valid input
    }





//Part E: getRangedDouble Method
public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
    double retValue;
    while (true) {
        System.out.print(prompt + " [" + low + " - " + high + "]: ");
        if (pipe.hasNextDouble()) {
            retValue = pipe.nextDouble();
            pipe.nextLine(); // Clear the newline
            if (retValue >= low && retValue <= high) {
                return retValue;
            } else {
                System.out.println("Please enter a value within the range.");
            }
        } else {
            System.out.println("Invalid input. Please enter a double.");
            pipe.nextLine(); // Clear the invalid input
        }
    }
}



//Part F:: getYNConfirm
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            input = pipe.nextLine().trim();

            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!isValid);

        return false; // This line will never be reached, but is required for compilation.
    }




    //Part G:getRegExString
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                return input;
            } else {
                System.out.println("Invalid input. Please match the pattern.");
            }
        }
    }




    public static void prettyHeader(String msg) {
        int width = 60;  // Total width of the header
        int msgLength = msg.length();  // Length of the message
        int totalPadding = width - msgLength - 6;  // Total padding (3 stars on each side)
        int padding = totalPadding / 2;  // Padding on each side

        // Print the top line of stars using a loop
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the line with stars and centered message
        System.out.print("***");  // First 3 stars
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");  // Left padding
        }
        System.out.print(msg);  // The message
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");  // Right padding
        }
        System.out.println("***");  // Last 3 stars

        // Print the bottom line of stars using a loop
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }





















}






