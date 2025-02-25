package leetcode.strings;

public class NPEExample {
    public static void main(String[] args) {
        printString(null, 3);
        
    }
    
    // static void printString(String s, int count) {
    //     if (s == null) return;
    //     for (int i = 0; i < count; i++) {
    //         System.out.println(s.toUpperCase());
    //     }
    // }
    static void printString(String s, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(s.toUpperCase()); // Exception in thread "main" java.lang.NullPointerException
        }
    }
}
