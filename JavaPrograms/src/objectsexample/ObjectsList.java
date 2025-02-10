package objectsexample;

import java.util.*;

public class ObjectsList {
    public static void main(String[] args) {

        List<Object> listobjects = new ArrayList<>();
        listobjects.add("Hello, world!");
        listobjects.add(1);
        listobjects.add(3.14);
        listobjects.add(true);
        listobjects.add(new Date());

        listobjects.forEach(System.out::println);
        // Object item = listobjects.get(0);

        // String str = (String) listobjects.get(1);

        List<?> list = new ArrayList<>();
        list = new ArrayList<String>();
        list = new ArrayList<Integer>();

        Object item1 = list.get(0);
        

    }

}
