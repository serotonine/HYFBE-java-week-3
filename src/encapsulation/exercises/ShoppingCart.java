package encapsulation.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 TODO:
 1. Create a class ShoppingCart with:
      - private field items (ArrayList of Strings). // Did Map instead.
      - private field totalPrice (double).

 2. Add methods:
      - addItem(String item, double price) → adds item and increases total price.
      - removeItem(String item, double price) → removes item if it exists and decreases total price.
      - getTotalPrice() → returns current total.
      - getItems() → returns the list of items.

 3. Add validation:
      - No negative prices allowed.
      - If you try to remove an item that doesn't exist, print a message.

 4. Challenge:
      - Add a method applyDiscount(double percentage) → reduces total price by that percentage,
        but only if percentage is between 0 and 50.
*/

public class ShoppingCart
{
    private Map<String, Double> items;
    private double totalPrice;
    public ShoppingCart(){
        this.items = new HashMap<>();
    }

     // addItem(String item, double price) → adds item and increases total price.
    public void addItem(String item, double price){
        try{
            if(price >= 0) {
                this.items.put(item, price);
            }
            else{
                throw new Exception("The price must be a positive number.");
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
      // removeItem(String item, double price) → removes item if it exists and decreases total price.
    public void removeItem(String item){
        try{
            if(this.items.get(item) != null){
                this.items.remove(item);
                System.out.printf("%s has been removed%n", item);
            }
            else{
                throw new Exception("No item " + item +" in the shopping list.");
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    // getTotalPrice() → returns current total.
    public double getTotalPrice(){
        double total = 0;
        for(double price:this.items.values()){
            total +=price;
        }
        return total;
    }

    // getItems() → returns the list of items.
    public void getItems(){
        System.out.println("My Shopping Card");
        this.items.forEach((name, price)->{
            System.out.printf("%-15s %5.2f € %n", name+":", price);
        });
    }
}
