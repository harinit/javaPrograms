package bytebytego.defaultexample;

public class EqualsOperator {
    
    String str1 = new String("Java");
    String str2 = new String("Java");

    int a = 10;
    int b = 10;

    public static void main(String[] args) {
        EqualsOperator obj = new EqualsOperator();
        System.out.println(obj.str1 == obj.str2);
        System.out.println(obj.str1.equals(obj.str2));

        System.out.println(obj.a == obj.b);
       // System.out.println(obj.a.equals(obj.b));
    }
}
