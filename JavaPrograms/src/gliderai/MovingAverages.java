package gliderai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovingAverages {
    // public static List<Float> smoothData(List<Integer> ar, int K) {
    //     List<Float> result = new ArrayList<>();
    //     int N = ar.size();

    //     if (K > N) {
    //         result.add(-1.0f);
    //         return result;
    //     }

    //     float sum = 0;
    //     for (int i = 0; i < K; i++) {
    //         sum += ar.get(i); // Initial sum
    //     }
    //     result.add(sum / K);

    //     for (int i = K; i < N; i++) {
    //         sum += ar.get(i) - ar.get(i - K); // Sliding window update
    //         result.add(sum / K);
    //     }

    //     return result;
    // }


    public static List<Float> smoothData(List<Integer> ar, int K) {
        List<Float> result = new ArrayList<>();
        int N = ar.size();

        // Edge case: If K is greater than N, return -1
        if (K > N) {
            result.add(-1.0f);
            return result;
        }

        // Compute initial sum of first K elements
        float sum = 0;
        for (int i = 0; i < K; i++) {
            sum += ar.get(i);
        }
        result.add(sum / K);

        // Use sliding window to update sum
        for (int i = K; i < N; i++) {
            sum += ar.get(i) - ar.get(i - K);
            result.add(sum / K);
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1, 1, 1, 1, 2, 1, 1);
        int K = 3;

        List<Float> result = smoothData(ar, K);
        for (float num : result) {
            System.out.printf("%.2f ", num);
        }

        List<Integer> ar1 = Arrays.asList(2,3,4,5,1,2,3,1,3);
        int K1 = 5;

        List<Float> result1 = smoothData(ar1, K1);
        for (float num : result1) {
            System.out.printf("%.2f ", num);
        }
    }
}
