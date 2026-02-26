package projects.shoppingCart;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the products available in the shop.
 */
public class ShoppingData {
   private final Map<String,Product> shoppingData;
    public ShoppingData(){
        shoppingData = new HashMap();
        shoppingData.put("coffee",  new Product("coffee", 5.50));
        shoppingData.put("rice",  new Product("rice", 3.50));
        shoppingData.put("milk",  new Product("milk", 1.40));
    }
    public Product getProduct(String key){
        return this.shoppingData.get(key);
    }
}
