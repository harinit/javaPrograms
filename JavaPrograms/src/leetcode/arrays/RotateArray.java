package leetcode.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/* 189. Rotate Array
Medium
Topics
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space? 

Approach 1: Reverse Method (Optimal O(n) Time, O(1) Space)

We can use 3 reversals:
	1.	Reverse the whole array.
	2.	Reverse the first k elements.
	3.	Reverse the remaining n - k elements.
    This approach has a time complexity of O(n) and uses O(1) extra space.

Approach 2: Two Pointer Method (Optimal O(n) Time, O(1) Space)
*/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        reverse(nums, 0, n - 1); // Step 1: Reverse whole array
        reverse(nums, 0, k - 1); // Step 2: Reverse first k elements
        reverse(nums, k, n - 1); // Step 3: Reverse remaining elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Using Java 8 
    public int[] rotateUsingJava8(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        
        return IntStream.concat(
                    Arrays.stream(nums, n - k, n), // Last k elements
                    Arrays.stream(nums, 0, n - k)  // First n-k elements
               ).toArray();
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        solution.rotate(nums1, 3);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [5,6,7,1,2,3,4]

        int[] nums2 = { -1, -100, 3, 99 };
        solution.rotate(nums2, 2);
        System.out.println(java.util.Arrays.toString(nums2)); // Output: [3,99,-1,-100]

        /*
         * Input: nums = [1,2,3], k = 0
         * Output: [1,2,3]
         */
        int[] nums3 = { 1, 2, 3 };
        solution.rotate(nums3, 0);
        System.out.println(java.util.Arrays.toString(nums3)); // Output: [1,2,3]

        /*
         * k > nums.length (Large k)
         * Input: nums = [1,2,3], k = 5
         * Output: [2,3,1] (same as k = 2)
         */

        int[] nums4 = { 1, 2, 3 };
        solution.rotate(nums4, 5);
        System.out.println(java.util.Arrays.toString(nums4)); // Output: [2,3,1]

    }
}
