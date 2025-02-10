package bytebytego;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int a = 0;

        System.out.println("Before " + a++ );
        System.out.println("After " + ++a );
        System.out.println(a++ == ++a );
    }
}
