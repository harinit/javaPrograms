package arrays;

import java.util.Arrays;

public class ArrayContainsElement {
    /*
     * Initialize a boolean variable contains to false.
     * Iterate through each element in the array.
     * If the current element is equal to the target element, set contains to true
     * and break out of the loop.
     * Print whether the array contains the target element based on the value of
     * contains.
     */

    public static void main(String[] args) {
        int[] numbers = { 3, 6, 9, 12, 15 };
        int target = 9;
        boolean contains = false;
        for (int num : numbers) {
            if (num == target) {
                contains = true;
                break;
            }
        }
        if (contains) {
            System.out.println("Array contains " + target);
        } else {
            System.out.println("Array does not contain " + target);
        }

        /*
         * Java 8 Stream API - Start
         *
         * Example array
         * int[] numbersArray = { 3, 6, 9, 12, 15 };
         * 
         * Check if the array contains the target element using the anyMatch() method.
         * Print whether the array contains the target element based on the result.
         */

        int[] numbersArray = { 3, 6, 9, 12, 15 };
        int targetInArray = 16;
        boolean containsTarget = Arrays.stream(numbersArray).anyMatch(num -> num == targetInArray);
        if (containsTarget) {
            System.out.println("Array contains " + targetInArray);
        } else {
            System.out.println("Array does not contain " + targetInArray);
        }
        // Java 8 Stream API - End

        // Java 17 Code - Start
        // Test cases
        testContainsElement(new int[] { 3, 6, 9, 12, 15 }, 9); // Positive test case
        testContainsElement(new int[] { 3, 6, 9, 12, 15 }, 10); // Element not in array
        testContainsElement(new int[] {}, 5); // Empty array
        testContainsElement(null, 5); // Null array
        // Java 17 Code - End
    }

    /**
     * Checks if an array contains a specific target element using a loop.
     * Throws exceptions for invalid inputs like null arrays.
     *
     * @param numbers the array of integers
     * @param target  the target integer to find
     * @return true if the target is found, false otherwise
     */
    public static boolean containsElementWithLoop(int[] numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }

        for (int num : numbers) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an array contains a specific target element using Java Streams.
     * Throws exceptions for invalid inputs like null arrays.
     *
     * @param numbers the array of integers
     * @param target  the target integer to find
     * @return true if the target is found, false otherwise
     */
    public static boolean containsElementWithStream(int[] numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }

        return Arrays.stream(numbers).anyMatch(num -> num == target);
    }

    /**
     * A method to test the functionality of the above methods and print results.
     *
     * @param numbers the array of integers
     * @param target  the target integer to find
     */
    public static void testContainsElement(int[] numbers, int target) {
        System.out.println("Testing array: " + Arrays.toString(numbers) + " with target: " + target);

        // Using loop
        try {
            boolean result = containsElementWithLoop(numbers, target);
            System.out.println("[Loop] Array contains " + target + ": " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("[Loop] Error: " + e.getMessage());
        }

        // Using Streams
        try {
            boolean result = containsElementWithStream(numbers, target);
            System.out.println("[Stream] Array contains " + target + ": " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("[Stream] Error: " + e.getMessage());
        }

        System.out.println();
    }
}
