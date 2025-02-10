package java11;

import java.util.stream.Collectors;

public class StringMethod {
    public static void main(String[] args) throws Exception {
        System.out.println(" ".isBlank()); //true
        
        String s = "Anupam";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true


        String str = "JD\nJD\nJD"; 
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));

        String str1 = " JD ";
        System.out.println(str1.strip());
        System.out.println(str1.stripLeading());
        System.out.println(str1.stripTrailing());

        String str2 = "  JD  ";
        System.out.println(str2.strip());
        System.out.println(str2.stripLeading());
        System.out.println(str2.stripTrailing());

    }
   
}
