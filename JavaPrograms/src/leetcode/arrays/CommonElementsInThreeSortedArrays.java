package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* Given three sorted arrays in non-decreasing order, print all common elements in these arrays.

Note: In case of duplicate common elements, print only once.

Examples: 

Input: A[] = {1, 5, 10, 20, 30} , B[] = {5, 13, 15, 20}, C[] = {5, 20} 
Output: 5 20
Explanation: 5 and 20 are common in all the arrays.


Input: A[] = {2, 5, 10, 30}, B[] = {5, 20, 34}, C[] = {5, 13, 19} 
Output: 5 
Explanation: 5 occurs multiple times in all the three arrays but it will be printed once. */

public class CommonElementsInThreeSortedArrays {

    public List<Integer> findCommonElements(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        Integer lastAdded = null; // Track last printed element to avoid duplicates

        while (i < A.length && j < B.length && k < C.length) {
            // If A[i], B[j], and C[k] are equal, add to result
            if (A[i] == B[j] && B[j] == C[k]) {
                if (lastAdded == null || lastAdded != A[i]) {
                    result.add(A[i]);
                    lastAdded = A[i]; // Update last printed element
                }
                i++;
                j++;
                k++; // Move all pointers
            }
            // Move the smallest pointer forward
            else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

    //Java 8 
     public List<Integer> findCommonElementsUsingJava8(int[] A, int[] B, int[] C) {
        // Convert arrays to sets
        Set<Integer> setA = Arrays.stream(A).boxed().collect(Collectors.toSet());
        Set<Integer> setB = Arrays.stream(B).boxed().collect(Collectors.toSet());
        Set<Integer> setC = Arrays.stream(C).boxed().collect(Collectors.toSet());

        // Find common elements using retainAll (intersection)
        setA.retainAll(setB);
        setA.retainAll(setC);

        return new ArrayList<>(setA);
    }
/* 
    Approach	                    Time Complexity	    Space Complexity	    Best Use Case
    Three-Pointer(O(N))              ✅O(N)	            O(1)	                Best for large inputs
    Streams + Sets (O(N log N)) ❌	O(N log N)	        O(N)	                More readable but slower 
    
    se the Three-Pointer approach (O(N)) for efficiency.
🚀 Use Streams (O(N log N)) if readability is more important.
*/
    public static void main(String[] args) {
        CommonElementsInThreeSortedArrays solution = new CommonElementsInThreeSortedArrays();

        int[] A1 = { 1, 5, 10, 20, 30 };
        int[] B1 = { 5, 13, 15, 20 };
        int[] C1 = { 5, 20 };
        System.out.println(solution.findCommonElements(A1, B1, C1)); // Output: [5, 20]

        int[] A2 = { 2, 5, 10, 30 };
        int[] B2 = { 5, 20, 34 };
        int[] C2 = { 5, 13, 19 };
        System.out.println(solution.findCommonElements(A2, B2, C2)); // Output: [5]

        // Input: A = {1, 2}, B = {3, 4}, C = {5, 6}
        // Output: []
        int[] A3 = { 1, 2 };
        int[] B3 = { 3, 4 };
        int[] C3 = { 5, 6 };
        System.out.println(solution.findCommonElements(A3, B3, C3)); // Output: []

        // Input: A = {5, 5, 5}, B = {5, 5, 5}, C = {5, 5, 5}
        // Output: [5]
        int[] A4 = { 5, 5, 5 };
        int[] B4 = { 5, 5, 5 };
        int[] C4 = { 5, 5, 5 };
        System.out.println(solution.findCommonElements(A4, B4, C4)); // Output: [5]

        // Input: A = {1}, B = {1}, C = {1}
        // Output: [1]
        int[] A5 = { 1 };
        int[] B5 = { 1 };
        int[] C5 = { 1 };
        System.out.println(solution.findCommonElements(A5, B5, C5)); // Output: [1]
    }

}
