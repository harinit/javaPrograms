import java.util.List;

public class VarForEachExample {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Cherry");

        list.forEach(item -> {
            var length = item.length();
            System.out.println("Item: " + item + ", Length: " + length);
        });
    }

    // forEach() is used to iterate over the collection, and var is used to infer
    // the type of the length variable within the loop.
}