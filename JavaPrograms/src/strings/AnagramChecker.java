package strings;

    import java.util.Arrays;

public class AnagramChecker {

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        // Sort both arrays // sort  by ASCII value
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    // Method to check if all strings in an array are anagrams of each other
    public static boolean areAnagramsOfEachOther(String[] strings) {
        // Compare each string with the first string
        for (int i = 1; i < strings.length; i++) {
            if (!isAnagram(strings[0], strings[i])) {
                return false;  // If any string is not an anagram of the first string, return false
            }
        }
        return true;  // All strings are anagrams of each other
    }


    public static void main(String[] args) {
        // Test cases
        String str1 = "ListeN";
        String str2 = "silenT";
        
        if (isAnagram(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        // Another test case
        String str3 = "hello";
        String str4 = "world";
        
        if (isAnagram(str3, str4)) {
            System.out.println(str3 + " and " + str4 + " are anagrams.");
        } else {
            System.out.println(str3 + " and " + str4 + " are not anagrams.");
        }


        // For an array of strings

         // Test case: Multiple strings
         String[] strings = {"listen", "silent", "enlist"};
        
         if (areAnagramsOfEachOther(strings)) {
             System.out.println("All strings are anagrams of each other.");
         } else {
             System.out.println("All strings are not anagrams of each other.");
         }
 
         // Another test case
         String[] strings2 = {"hello", "world", "bye"};
         
         if (areAnagramsOfEachOther(strings2)) {
             System.out.println("All strings are anagrams of each other.");
         } else {
             System.out.println("All strings are not anagrams of each other.");
         }
    }





    // // Method to check if two strings are anagrams
    // public static boolean isAnagram(String str1, String str2) {
    //     // If lengths are different, they cannot be anagrams
    //     if (str1.length() != str2.length()) {
    //         return false;
    //     }
        
    //     // Convert strings to character arrays
    //     char[] arr1 = str1.toCharArray();
    //     char[] arr2 = str2.toCharArray();
        
    //     // Sort both arrays
    //     Arrays.sort(arr1);
    //     Arrays.sort(arr2);
        
    //     // Compare sorted arrays
    //     return Arrays.equals(arr1, arr2);
    // }

    
    
}


