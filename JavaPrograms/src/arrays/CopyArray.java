package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class CopyArray {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        int[] copiedArray = new int[array.length];

        // Copy elements from the original array to the copied array
        System.arraycopy(array, 0, copiedArray, 0, array.length);

        // Print the copied array
        System.out.print("Copied Array: ");
        for (int i : copiedArray) {
            System.out.print(i + " ");
        }

        String[] stringArray = new String[] { "Alice", "Bob", "Charlie", "David", "Eve" };
        String[] copiedStringArray = new String[stringArray.length];

        // Copy elements from the original array to the copied array
        System.arraycopy(stringArray, 0, copiedStringArray, 0, stringArray.length);

        // Print the copied array
        System.out.println("\nCopied String Array: ");
        for (String s : copiedStringArray) {
            System.out.println(s + " ");
        }

        String[] nums = new String[] { "1", "9", "10" };
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        /*
         * Comparison           ASCII/Unicode                                       Order Decision
         * "1" vs "10"          '1' == '1' → Continue comparing next character      ✅ "1" comes first
         * "10" vs "9"          '1' < '9' → "10" comes before "9"                   ✅ "10" is placed before "9"
         */

        //  If you want numeric sorting, convert the strings to integers and then sort.

        String[] nums1 = new String[] { "1", "9", "10" };
        String[] nums2 = new String[] { "2", "11", "03", "100", "9" };
        int[] numbers = Arrays.stream(nums1)
                .mapToInt(Integer::parseInt)
                .toArray();

         // Sort by parsing as integers
        Arrays.sort(nums2, Comparator.comparingInt(Integer::parseInt));       
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(nums2));

    }
}
