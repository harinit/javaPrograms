package strings;
public class StringIsBlankExample {
    public static void main(String[] args) {
        String str1 = "   ";  // Only spaces
        String str2 = "Hello World";  // Non-blank string

        System.out.println("Is str1 blank? " + str1.isBlank());
        System.out.println("Is str2 blank? " + str2.isBlank());
    }
}
