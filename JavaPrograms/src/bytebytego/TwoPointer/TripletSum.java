package bytebytego.TwoPointer;

/* Triplet Sum
Medium
Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0 .
 The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicates). 
 If no such triplets are found, return an empty array.

Each triplet can be arranged in any order, and the output can be returned in any order.

Example:
Input: nums = [0, -1, 2, -3, 1]
Output: [[-3, 1, 2], [-1, 0, 1]] */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* 
where we need to find all unique triplets [a, b, c] such that a + b + c = 0.
 We’ll use the two-pointer technique combined with sorting to achieve an efficient solution. */
public class TripletSum {

    public static List<List<Integer>> tripletSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        
        // Sort the array to facilitate finding triplets
        Arrays.sort(nums);
        
        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values of `a`
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Use two pointers to find pairs that sum to the negative of nums[i]
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (currentSum == 0) {
                    // Found a valid triplet
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate values of `b` and `c`
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }
        
        return triplets;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {0, -1, 2, -3, 1};
        List<List<Integer>> result = tripletSum(nums);
        
        // Print the result
        System.out.println(result);
    }
}

/* Explanation:
	1.	Sorting the Array: We start by sorting the array to allow us to use the two-pointer technique and to easily skip duplicates.
	2.	Outer Loop: The outer loop iterates through each element (from index 0 to n-3), fixing the current element as the first element of the triplet.
	3.	Two-pointer Search: For each fixed element nums[i], we use two pointers (left and right) starting from the indices immediately after i and at the end of the array, respectively. The goal is to find two numbers that sum to -(nums[i]).
	4.	Skipping Duplicates: If we find a valid triplet, we skip over any duplicate values of left and right to avoid repeating triplets.
	5.	Return Result: All unique triplets are stored in the triplets list, which is returned at the end.

Time Complexity:
	•	O(n^2), where n is the length of the input array. The outer loop runs n times, and the two-pointer search inside the loop operates in O(n) time.

Space Complexity:
	•	O(k), where k is the number of triplets found, since the result is stored in a list.
 */