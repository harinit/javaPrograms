package java17;


//The instanceof operator in Java is used to test whether an object is an instance of a specific class or subclass. 
//It helps in type checking and avoiding ClassCastException.
sealed class Shape permits Circle, Rectangle {}

final class Circle extends Shape {}

final class Rectangle extends Shape {}

final class Square {}

public class SealedExample {
    static void process(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("It's a Circle");
        } else if (shape instanceof Rectangle) {
            System.out.println("It's a Rectangle");
        }

        // //✅ Old Way (before Java 16)
        // Object obj = "Hello";
        // if (obj instanceof String) {
        // String obj;
        // String str = (String) obj; // Explicit casting
        // System.out.println(str.length());
        // }
        // //✅ New Way (Java 16+) - Pattern Matching for instanceof
        // Object obj = "Hello";
        // if (obj instanceof String str) {
        // System.out.println(str.length());
        // }
    }

    public static void main(String[] args) {
        process(new Circle());
        process(new Rectangle());
        // process(new Square());
    }

}
