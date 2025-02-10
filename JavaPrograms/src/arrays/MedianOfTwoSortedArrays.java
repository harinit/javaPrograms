package arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        // Test cases
        testFindMedian(new int[] { 0, 2, 5, 6, 8 }, new int[] { 1, 3, 7 }); // Output: 4.0
        /*
         * Nums1: [0, 2, 5, 6, 8]
         * Nums2: [1, 3, 7] // sorted array : [0, 1, 2, 3, 5, 6, 7, 8] ==> 5 + 3  = 8/2 = 4
         * Median: 4.0
         */
        testFindMedian(new int[] { 0, 2, 5, 6, 8 }, new int[] { 1, 3, 7, 9 }); // Output: 5.0
        /*
         * Nums1: [0, 2, 5, 6, 8]
         * Nums2: [1, 3, 7, 9]
         * Sorted Array: [0, 1, 2, 3, 5, 6, 7, 8, 9] ==> 5
         * Median: 5.0
         */
        testFindMedian(new int[] {}, new int[] { 1 }); // Edge case: Single element, Output: 1.0
        /*
         * Nums1: []
         * Nums2: [1]
         * Median: 1.0
         */
        testFindMedian(new int[] { 1 }, new int[] { 2 }); // Output: 1.5
        /*
         * Nums1: [1]
         * Nums2: [2]
         * Median: 1.5
         */
        testFindMedian(new int[] {}, new int[] { 1, 2, 3 }); // Edge case: One array empty, Output: 2.0
        /*
         * Nums1: []
         * Nums2: [1, 2, 3]
         * Median: 2.0
         */
        testFindMedian(new int[] { 1, 3 }, new int[] { 2, 4, 5, 6 }); // Output: 3.5

        testFindMedian(null, new int[] { 1, 2, 3 }); // Edge case: Null array, Exception
        /*
         * Nums1: null
         * Nums2: [1, 2, 3]
         * Error: Both input arrays cannot be null or empty.
         */
        testFindMedian(new int[] { 1, 2 }, null); // Edge case: Null array,
        /*
         * Exception Nums1: [1, 2]
         * Nums2: null
         * Error: Both input arrays cannot be null or empty.
         */
        testFindMedian(new int[] {}, new int[] {}); // Edge case: Both empty, Exception
        /*
         * Nums1: []
         * Nums2: []
         * Error: Both input arrays cannot be null or empty.
         */
    }

    /**
     * Finds the median of two sorted arrays.
     *
     * @param nums1 The first sorted array.
     * @param nums2 The second sorted array.
     * @return The median value as a double.
     * @throws IllegalArgumentException If both arrays are null or empty.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Validate input
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            throw new IllegalArgumentException("Both input arrays cannot be null or empty.");
        }

        // Handle cases where one of the arrays is null or empty
        if (nums1 == null || nums1.length == 0) {
            return findMedianOfSingleArray(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianOfSingleArray(nums1);
        }

        // Ensure nums1 is the smaller array for efficient binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) { // Even length
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else { // Odd length
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) { // Move left in nums1
                high = partitionX - 1;
            } else { // Move right in nums1
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }

    /**
     * Finds the median of a single sorted array.
     *
     * @param nums The sorted array.
     * @return The median value as a double.
     */
    private static double findMedianOfSingleArray(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        } else {
            return nums[n / 2];
        }
    }

    /**
     * Helper method to test the function with various inputs.
     *
     * @param nums1 The first sorted array.
     * @param nums2 The second sorted array.
     */
    public static void testFindMedian(int[] nums1, int[] nums2) {
        System.out.println("Nums1: " + Arrays.toString(nums1));
        System.out.println("Nums2: " + Arrays.toString(nums2));

        try {
            double result = findMedianSortedArrays(nums1, nums2);
            System.out.println("Median: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
    }
}

/*
 * Explanation
 * 
 * Optimal Approach
 * 
 * The binary search solution works by dividing the arrays into two partitions
 * such that:
 * 1. All elements in the left partition are less than or equal to all elements
 * in the right partition.
 * 2. The median can then be computed based on the maximum value in the left
 * partition and the minimum value in the right partition.
 * 
 * Steps
 * 1. Use binary search on the smaller array (nums1) to ensure efficiency.
 * 2. Partition nums1 and nums2 such that the left partition contains half the
 * total elements.
 * 3. Check if the partitions are valid (i.e., maxX <= minY and maxY <= minX).
 * 4. Compute the median:
 * • If the total number of elements is even, the median is the average of the
 * largest value in the left partition and the smallest value in the right
 * partition.
 * • If the total number of elements is odd, the median is the largest value in
 * the left partition.
 * 
 * Time Complexity
 * • O(\log(\min(n, m))), where n and m are the lengths of the two arrays.
 * 
 * Space Complexity
 * • O(1): No additional data structures are used.
 * 
 * 	1.	One or both arrays are empty:
	•	If one array is empty, the median is calculated from the non-empty array.
	•	If both arrays are empty, an exception is thrown.
	2.	One array has a single element:
	•	The result is calculated correctly, even when one array has just one element.
	3.	Null arrays:
	•	An exception is thrown with a descriptive message.
 * 
 */