import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("/Users/harinit/Desktop/javacourse/JavaPrograms/JavaPrograms/src/example.txt"));
            System.out.println(content);

            Path p = Path.of("/Users/harinit/Desktop/javacourse/JavaPrograms/JavaPrograms/src/example_copy.txt");
            Files.writeString(p,"Added new lines", StandardOpenOption.APPEND);
            
            String s1 = Files.readString(p);
            //Files.writeString(p,"Added new lines with new options", StandardOpenOption.APPEND);
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}