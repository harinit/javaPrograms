package strings;
public class ReverseString {

    public static void reverseCharArray(char[] array) {

        int left = 0, right = array.length - 1;
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseRecursively(String input1) {
        if (input1.isEmpty()) {
            return input1;
        }
        return reverseRecursively(input1.substring(1)) + input1.charAt(0);
    }

    public static void main(String[] args) {

        // With String Builder
        String input = "Hello, Java!";
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed String: " + reversed);

        // Without String Builder
        // ReverseStringWithoutString

        char[] array = { 'H', 'a', 'r', 'i', 'n', 'i', ' ', 'J', 'a', 'v', 'a', '!' };
        reverseCharArray(array);
        System.out.println("Reversed Char Array: " + new String(array));

        // Reverse String Recursively
        String input1 = "Hello Dear Recursion";
        String reversed1 = reverseRecursively(input1);
        System.out.println("Reversed String through Recursion: " + reversed1);
    }
}
