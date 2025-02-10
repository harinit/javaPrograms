package bytebytego.defaultexample;

public class StringExample {
    
    public static void main(String[] args) {
        String str = "hello";
        str += " world";
        System.out.println(str);

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");
        System.out.println(sb.toString());

        StringBuffer sbf = new StringBuffer("hello");
        sbf.append(" world");
        System.out.println(sbf.toString());
    }
    
}
