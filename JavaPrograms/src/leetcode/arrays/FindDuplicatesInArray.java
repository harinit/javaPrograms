package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* 442. Find All Duplicates in an Array
Medium

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each 
integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, 
excluding the space needed to store the output

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:

Input: nums = [1,1,2]
Output: [1]

Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice. */
public class FindDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Get index (1-based to 0-based)

            if (nums[index] < 0) {
                result.add(index + 1); // If already negative, it's a duplicate
            } else {
                nums[index] = -nums[index]; // Mark the number as visited
            }
        }

        return result;
    }

    // Using Java 8
    public List<Integer> findDuplicatesUsingJava8(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 2) // Find values appearing twice
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FindDuplicatesInArray solution = new FindDuplicatesInArray();

        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(solution.findDuplicates(nums1)); // Output: [2,3]

        int[] nums2 = { 1, 1, 2 };
        System.out.println(solution.findDuplicates(nums2)); // Output: [1]

        int[] nums3 = { 1 };
        System.out.println(solution.findDuplicates(nums3)); // Output: []
    }
}
