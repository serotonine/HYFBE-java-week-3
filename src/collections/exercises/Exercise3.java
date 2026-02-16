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
public class Exercise3
{
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Mom","+33561735680");
        phoneBook.put("Rob","+32645668900");
        phoneBook.put("Rob","+32645668900");
        phoneBook.put("Cloclo","+33465789654");
        System.out.println("Phonebook: " + phoneBook);
        System.out.println("Get one element from phonebook: " + phoneBook.get("Mom"));
        phoneBook.remove("Cloclo");
        System.out.println("Phonebook after removal: " + phoneBook);
    }
}
