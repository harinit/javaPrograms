package bytebytego;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int a = 0;

        System.out.println("Before " + a++);
        System.out.println("After " + ++a);
        System.out.println(a++ == ++a);

        int x = 10;
        int y = 0;
        while (x-- > y) { // Explicitly using the decrement operator and greater than condition
            //while (x --> y) { // Looks like an arrow but actually means x-- > y
            //while ((x--) > y) { // This is the correct way to write the condition
            System.out.println("x --> y :: " + x);
        }
    }
}
