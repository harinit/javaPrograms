package gliderai;

import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // Java 17 feature: var for Type Inference
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements.");
        }

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found: No two numbers sum up to the target.");
    }


    //Before Java 17
    public int[] twoSumSol(int[] nums, int target) {

        
        //Before Java 17
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number with its index
            map.put(nums[i], i);
        }

        return new int[]{}; // Should never reach here as per problem constraints
    }

    // find all valid pairs in the array
    public int[] twoSumStreamSol(int[] nums, int target) {

        // find all valid pairs in the array
        var map1 = new HashMap<Integer, Integer>();

        // add return to Line 61
         IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int complement = target - nums[i];

                    if (map1.containsKey(complement)) {
                        return new int[]{map1.get(complement), i};
                    }

                    map1.put(nums[i], i);
                    return null;
                })
                .filter(Objects::nonNull) // Remove null values
                .collect(Collectors.toList()); // Collect all valid pairs

        // Java 8 and later --> Find only one pair in the array
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements.");
        }

        var map = new HashMap<Integer, Integer>();

        return IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return new int[]{map.get(complement), i};
                    }
                    map.put(nums[i], i);
                    return null;
                })
                .filter(result -> result != null) // Filter out null results
                .findFirst() // Get the first valid result
                .orElseThrow(() -> new IllegalArgumentException("No solution found: No two numbers sum up to the target."));
    
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        try {
            int[] nums = { 2, 7, 11, 15 };
            int target = 9;

            int[] result = solution.twoSum(nums, target);
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


/* New Features Used from Java 17
	1.	var for Type Inference – Reduces verbosity (used for HashMap).
	2.	Enhanced Exception Handling – Uses IllegalArgumentException with meaningful messages.
	3.	Improved Readability & Robustness. 
    
    
    Edge Case	                                    How It’s Handled
    Null Array (null)	                            Throws IllegalArgumentException
    Array with Less than 2 Elements ([1])	        Throws IllegalArgumentException
    No Valid Pair Exists ([1, 2, 3], target=10)	    Throws IllegalArgumentException
    Negative Numbers ([-1, -2, -3, -4])	            Works correctly
    Zeros and Duplicates ([0, 0, 3, 4], target=0)	Works correctly
    Large Input Size (10^6 elements)	            Runs in O(n) and performs well
    
    */

    // Time Complexity: O(n)
    // Space Complexity: O(n)