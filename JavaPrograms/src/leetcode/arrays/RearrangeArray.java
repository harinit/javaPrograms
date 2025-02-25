package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.Scanner;
import java.util.stream.Collectors;

/* Input:
The first line contains an integer 'T' which denotes the number of test cases or queries to be run. Then, the T test cases follow.

The first line of each test case or query contains an integer 'N' representing the size of the array (arr).

The second line contains 'N' single space-separated integers, representing the elements in the array.
Output:
For each test case, output a rearranged array where every non-negative integer is followed by a negative integer and vice-versa.
Example:
Input:
array = {4, -9, -2, 6, -8}
Output: {-9, 4, -2, 6, -8}

Input:
array = {1, 2, 3, -5}
Output: {-5, 1, 2, 3}
Constraints:
1 <= T <= 10
1 <= N <= 10^5
Sum of N over all test cases does not exceed 10^5.
-(10^9) <= arr[i] <= 10^9
Time limit: 1 second
Note:
The number of positive integers and negative integers may not be equal. In such cases, add the extra integers at the end. For a single array, multiple solutions may be possible,
 just rearrange the array in any one possible way. */
public class RearrangeArray {
 public static void rearrangeArray(int[] arr, int n) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) positives.add(num);
            else negatives.add(num);
        }

        int posIdx = 0, negIdx = 0, i = 0;
        
        // Alternately merge positive and negative numbers
        while (posIdx < positives.size() && negIdx < negatives.size()) {
            arr[i++] = negatives.get(negIdx++);
            arr[i++] = positives.get(posIdx++);
        }

        // Append remaining elements
        while (negIdx < negatives.size()) arr[i++] = negatives.get(negIdx++);
        while (posIdx < positives.size()) arr[i++] = positives.get(posIdx++);

        // Print the result
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrangeArray(int[] arr) {
        List<Integer> positives = Arrays.stream(arr)
                .filter(x -> x >= 0)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> negatives = Arrays.stream(arr)
                .filter(x -> x < 0)
                .boxed()
                .collect(Collectors.toList());

        int posIdx = 0, negIdx = 0, i = 0;

        // Merge alternately
        while (posIdx < positives.size() && negIdx < negatives.size()) {
            arr[i++] = negatives.get(negIdx++);
            arr[i++] = positives.get(posIdx++);
        }

        // Append remaining elements
        while (negIdx < negatives.size()) arr[i++] = negatives.get(negIdx++);
        while (posIdx < positives.size()) arr[i++] = positives.get(posIdx++);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int T = sc.nextInt(); // Number of test cases

        // while (T-- > 0) {
        //     int N = sc.nextInt(); // Array size
        //     int[] arr = new int[N];

        //     for (int i = 0; i < N; i++) {
        //         arr[i] = sc.nextInt();
        //     }

        //     rearrangeArray(arr, N);
        // }
        // sc.close();

        int[] arr = {4, -9, -2, 6, -8};
        rearrangeArray(arr); // Output: [-9, 4, -2, 6, -8]

        int[] arr2 = {1, 2, 3, -5};
        rearrangeArray(arr2); // Output: [-5, 1, 2, 3]
    }
}
