package collections.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 1. Create a List<String> shoppingList.
 2. Add 5 items.
 3. Remove one item.
 4. Print the final list.
*/

public class Exercise1
{
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Macarons Ladurée");
        shoppingList.add("Eggplant caviar");
        shoppingList.add("Milk chocolate Neuhaus");
        shoppingList.add("Quiche Renard");
        shoppingList.add("Pistaccio from Iran");
        System.out.println("shoppingList : "+ shoppingList);
        shoppingList.remove(4);
        System.out.println("shoppingList : "+ shoppingList);
        shoppingList.set(1,"Babaganoush from Ô Liban");
        System.out.println("shoppingList : "+ shoppingList);
    }
}
