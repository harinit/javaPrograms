/* Given an array of integers sorted in ascending order and a target value, 
return the indexes of any pair of numbers in the array that sum to the target. 
The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

Example 1:
Input: nums = [-5, -2, 3, 4, 6], target = 7
Output: [2, 3]
Explanation: nums[2] + nums[3] = 3 + 4 = 7

Example 2:
Input: nums = [1, 1, 1], target = 2
Output: [0, 1]
Explanation: other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2] or [2, 1]. */

package bytebytego.TwoPointer;
import java.util.List;
import java.util.ArrayList;

public class PairSumSorted {

    public static List<Integer> pairSumSorted(List<Integer> nums, int target) {
        // Initialize two pointers
        int left = 0, right = nums.size() - 1;
        
        // Loop until the two pointers meet
        while (left < right) {
            int currentSum = nums.get(left) + nums.get(right);
            
            if (currentSum == target) {
                // If the sum matches the target, return the indices
                List<Integer> result = new ArrayList<>();
                result.add(left);
                result.add(right);
                return result;
            } else if (currentSum < target) {
                // If the sum is less than the target, move the left pointer to the right
                left++;
            } else {
                // If the sum is greater than the target, move the right pointer to the left
                right--;
            }
        }
        
        // If no pair is found, return an empty list
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> nums1 = List.of(-5, -2, 3, 4, 6);
        int target1 = 7;
        System.out.println(pairSumSorted(nums1, target1));  // Output: [2, 3]

        // Example 2
        List<Integer> nums2 = List.of(1, 1, 1);
        int target2 = 2;
        System.out.println(pairSumSorted(nums2, target2));  // Output: [0, 1]
    }
}

/* Explanation:
	1.	Two Pointers: We use two pointers, left and right, initialized at the start and end of the list, respectively.
	2.	Sum Calculation: We calculate the sum of nums.get(left) + nums.get(right).
	•	If the sum is equal to the target, return the indices [left, right] as a list.
	•	If the sum is less than the target, increment the left pointer to increase the sum.
	•	If the sum is greater than the target, decrement the right pointer to decrease the sum.
	3.	Return Empty: If no valid pair is found, return an empty list.

Time Complexity:
	•	The time complexity is O(n), where n is the number of elements in the list. 
    This is because each element is processed at most once by either the left or right pointer.

Example Outputs:
	•	Example 1: For nums = [-5, -2, 3, 4, 6] and target = 7, the output will be [2, 3] because nums[2] + nums[3] = 3 + 4 = 7.
	•	Example 2: For nums = [1, 1, 1] and target = 2, the output will be [0, 1] because nums[0] + nums[1] = 1 + 1 = 2.

This code works with both Java 11 and Java 17, as it uses standard Java 8+ features such as List and List.of. */