package leetcode.arrays;

/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j,
 i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

Optimal Approach: Sorting + Two Pointers (O(n^2) Time, O(1) Extra Space)
	1.	Sort the Array → Helps avoid duplicate triplets efficiently.
	2.	Fix One Element and Use Two-Pointer:
	•	Fix nums[i] as the first element.
	•	Use two-pointer (left, right) to find nums[left] + nums[right] = -nums[i].
	•	Move left or right based on sum.
	3.	Skip Duplicates:
	•	If nums[i] == nums[i-1], skip to avoid duplicate triplets.
    
    */
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicate elements

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate `left` values
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    // Skip duplicate `right` values
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger sum, move `left` right
                } else {
                    right--; // Need a smaller sum, move `right` left
                }
            }
        }
        return result;
    }

    // Using Java 8
    public List<List<Integer>> threeSumUsingJava8(int[] nums) {
        Arrays.sort(nums);
        return Arrays.stream(nums)
                .distinct()
                .boxed()
                .flatMap(i -> Arrays.stream(nums)
                        .filter(j -> j > i)
                        .boxed()
                        .flatMap(j -> Arrays.stream(nums)
                                .filter(k -> k > j && i + j + k == 0)
                                .boxed()
                                .map(k -> Arrays.asList(i, j, k))))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solution.threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = { 0, 1, 1 };
        System.out.println(solution.threeSum(nums2)); // Output: []

        int[] nums3 = { 0, 0, 0 };
        System.out.println(solution.threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}