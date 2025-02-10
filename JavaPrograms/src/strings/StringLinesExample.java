package strings;
public class StringLinesExample {
    public static void main(String[] args) {
        String text = "Hello\nWorld\nJava 11";

        text.lines().forEach(System.out::println);
    }
}