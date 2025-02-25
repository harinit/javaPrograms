package leetcode.arrays;

import java.util.stream.DoubleStream;

public class Test {
    public static void main(String[] args) {
        var doubles = DoubleStream.of(0.45,0.42,0.49);
        System.out.println(doubles.filter(e -> e>0.45).count());
    }
}
