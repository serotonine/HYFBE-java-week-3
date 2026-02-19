package collections.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 1. Create a Map<String, String> phoneBook (name → phone number).
 2. Add 3 entries.
 3. Print all entries.
 4. Retrieve one number by name.
 5. Remove one entry.
*/
public class Exercise3 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Mom", "+33561");
        phoneBook.put("Rob", "+32645668900");
        phoneBook.put("Rob", "+32645668900");
        phoneBook.put("Cloclo", "+33465789654");
        phoneBook.putIfAbsent("Mom", "+335456");
        // System.out.println("Phonebook: " + phoneBook);
        // System.out.println("Get one element from phonebook: " + phoneBook.get("Mom"));
        phoneBook.remove("Cloclo");
        System.out.println("/// LOOPS ///");

        phoneBook.computeIfPresent("Mom", (key, acc)-> acc += "734680");
        phoneBook.computeIfAbsent("Cleopatre", key-> "00457896754");
        phoneBook.put("Rob", "none");
        printMap(phoneBook);
    }

    public static void printMap(Map<String, String> aMap) {
        System.out.println("Writing with keySet and enhanced loop");
        for(String key : aMap.keySet()) {
            System.out.print( aMap.get(key) + " ");
        }
        System.out.println();
        System.out.println("Writing with entrySet and enhanced loop");
        for(Map.Entry<String, String> entry : aMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Writing with forEach and lambda function");
        aMap.forEach((key, value) -> System.out.println(key + "'s phone number is: " + value));
        System.out.println("Writing with toString method of Map");
        System.out.println(aMap);
        System.out.println("Writing the values");
        for (String value : aMap.values()) {
            System.out.println("value: " + value);
        }
    }


}


