package leetcode.arrays;

import java.util.stream.IntStream;

/* Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.


Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
which is more subtle.
 */

// Kadane's Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;

        /*
         * int max=Integer.MIN_VALUE; 
         * int sum = 0; 
         * for(int i=0; i<nums.length; i++) {
         * sum=Math.max(nums[i], nums[i]+sum);
         *  max=Math.max(sum,max); 
         * } 
         * return max;
         */
    }

    /*
     * Explanation of Java 8 Features Used
     * 1. IntStream.of(nums).forEach()
     * • Converts the array into a stream for iteration.
     * • Uses forEach() to process each element.
     * 2. Using an array {maxSum, currentSum} instead of mutable variables
     * • Since Java streams don’t allow modification of local variables inside
     * lambdas, we store maxSum and currentSum in an array.
     * 3. Functional Kadane’s Logic Inside forEach()
     * • currentSum = max(num, currentSum + num);
     * • maxSum = max(maxSum, currentSum);
     * 
     * Why Not Use reduce()?
     * 
     * reduce() is mainly for aggregating results (like sum or product). Since we
     * need to track two values (maxSum and currentSum),
     * reduce() becomes impractical.
     */
    // Java 8
    public int maxSubArrayLeetcode(int[] nums) {

        int[] result = { Integer.MIN_VALUE, 0 }; // {maxSum, currentSum}

        IntStream.of(nums).forEach(num -> {
            result[1] = Math.max(num, result[1] + num); // currentSum = max(num, currentSum + num)
            result[0] = Math.max(result[0], result[1]); // maxSum = max(maxSum, currentSum)
        });

        return result[0];
    }

    // Divide and Conquer Approach
    // Divide & Conquer Solution (O(n log n))
    public int maxSubArrayDQ(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right)
            return nums[left]; // Base case

        int mid = left + (right - left) / 2;

        // Find max subarray sum in left and right halves
        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);

        // Find max crossing sum
        int crossSum = maxCrossingSum(nums, left, mid, right);

        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int sum = 0;

        // Find max sum from mid to left
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        // Find max sum from mid+1 to right
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum; // Best sum across mid
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution.maxSubArray(nums1)); // Output: 6

        int[] nums2 = { 1 };
        System.out.println(solution.maxSubArray(nums2)); // Output: 1

        int[] nums3 = { 5, 4, -1, 7, 8 };
        System.out.println(solution.maxSubArray(nums3)); // Output: 23

        int[] nums4 = { -1, -2, -3, -4 };
        System.out.println(solution.maxSubArray(nums4)); // Output: -1

        // Divide & Conquer Approach
        MaxSubArray solution1 = new MaxSubArray();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution1.maxSubArrayDQ(nums)); // Output: 6
    }

    // public static void main(String[] args) {

    // }
}

// class Solution {
// public int maxSubArray(int[] nums) {
// int res = nums[0];
// int total = 0;

// for (int n : nums) {
// if (total < 0) {
// total = 0;
// }

// total += n;
// res = Math.max(res, total);
// }

// return res;
// }

// public static void main(String[] args) {
// MaxSubArray solution = new MaxSubArray();
// int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
// System.out.println(solution.maxSubArray(nums1)); // Output: 6

// int[] nums2 = { 1 };
// System.out.println(solution.maxSubArray(nums2)); // Output: 1

// int[] nums3 = { 5, 4, -1, 7, 8 };
// System.out.println(solution.maxSubArray(nums3)); // Output: 23

// int[] nums4 = { -1, -2, -3, -4 };
// System.out.println(solution.maxSubArray(nums4)); // Output: -1
// }
// }