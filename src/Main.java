// Import the Random class
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        // Part 1 - Task 1: Declare an array named dataPoints with length of 100
        int[] dataPoints = new int[100];

        // Part 1 - Task 2: Initialize each element with a random value between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Part 1 - Task 3: Display the dataPoints values in the specified format
        System.out.print("Data Points: ");
        for (int i = 0; i < dataPoints.length; i++) {
            if (i < dataPoints.length - 1) {
                System.out.print(dataPoints[i] + " | ");
            } else {
                System.out.print(dataPoints[i]);
            }
        }
        System.out.println();

        // Part 1 - Task 4: Calculate and display the sum and average of dataPoints
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = (double) sum / dataPoints.length;
        System.out.printf("\n The sum of dataPoints is: %d%n", sum);
        System.out.printf("\nThe average of dataPoints is: %.2f%n", average);

        // Part 2 - Task 5: Prompt the user for an integer between 1 and 100
        int searchValue = getRangedInt(scanner, "\nEnter an integer between 1 and 100: ", 1, 100);

        // Part 2 - Task 6: Count how many times the user's value appears in dataPoints
        int count = 0;
        for (int val : dataPoints) {
            if (val == searchValue) {
                count++;
            }
        }
        System.out.printf("\n The value %d appears %d time(s) in the dataPoints array.%n", searchValue, count);

        // Part 2 - Task 7: Find the first occurrence of the user's value in dataPoints
        searchValue = getRangedInt(scanner, "\n Enter another integer between 1 and 100 to search for its position: ", 1, 100);
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue) {
                System.out.printf("\n The value %d was found at array index %d.%n", searchValue, i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("\n The value %d was not found in the array.%n", searchValue);
        }

        // Part 2 - Task 8: Find the minimum and maximum values in dataPoints
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int val : dataPoints) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.printf("\n The minimum value in dataPoints is: %d%n", min);
        System.out.printf("\n The maximum value in dataPoints is: %d%n", max);

        // Part 2 - Task 9: Calculate and display the average using getAverage method
        System.out.printf("\n Average of dataPoints is: %.2f%n", getAverage(dataPoints));
    }

    // Part 2 - Task 9: Method to calculate the average of an int array
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return (double) sum / values.length;
    }

    // Helper method to get a ranged integer from the user
    public static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        int value;
        do {
            System.out.print(prompt);
            value = scanner.nextInt();
        } while (value < min || value > max);
        return value;
    }
}
