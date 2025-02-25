package leetcode.arrays;

/*   169. Majority Element
Solved
Easy

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that 
the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space? */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> hash = new HashMap<>();
        // int res = 0;
        // int majority = 0;

        // for (int n : nums) {
        // hash.put(n, 1 + hash.getOrDefault(n, 0));
        // if (hash.get(n) > majority) {
        // res = n;
        // majority = hash.get(n);
        // }
        // }

        // return res;

        int res = 0;
        int majority = 0;

        for (int n : nums) {
            if (majority == 0) {
                res = n;
                // Ifmajorityis0, it means we have encountered a new element which might be the
                // majority element.
                // So, we updateresto the current elementn.
            }

            majority += n == res ? 1 : -1;
            // We update the majoritycount based on whether the current element n is equal to
            // the current majority elementres.
            // If n is equal to res, we increment the majority count by 1. Otherwise, we decrement
            // it by 1.

        }

        return res;

    }
}
