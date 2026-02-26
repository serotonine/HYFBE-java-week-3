package projects.shoppingCart;

/**
 * 4. **E-Commerce Shopping Cart** 🛒
 *
 * This project simulates a simple e-commerce shopping cart system.
 * It includes the following classes: `Product`, `Cart`, and `User`.
 * Features: add/remove products, calculate total price, and manage product quantities.
 */
import java.text.NumberFormat;
import java.util.*;

public class ShoppingCart {

    /**
     * Main method to demonstrate the shopping cart functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // All the available products are stored in this Map.
        ShoppingData shoppingData = new ShoppingData();
        // Each user has a cart.
        User mySelf = new User("Myself");
        Cart cart = mySelf.getCart();

        cart.addProduct(shoppingData.getProduct("coffee"));
        cart.addProduct(shoppingData.getProduct("coffee"));

        cart.addProduct(shoppingData.getProduct("rice"));
        cart.addProduct(shoppingData.getProduct("milk"));
        cart.increaseProductQuantity("milk", 5);
        cart.printCart();
        System.out.println("\n\nDecrease Milk quantity");
        cart.decreaseProductQuantity("milk", 1);
        cart.printCart();

        System.out.println("\n\nget product quantity by Product = " + cart.getProduct(shoppingData.getProduct("coffee")));
        System.out.println("get product quantity by Product name = " + cart.getProduct("coffee"));
    }
}

/**
 * Represents a product in the shopping cart.
 */
class Product {
    private String name;
    private double price;

    /**
     * Constructs a new Product with the given name and price.
     *
     * @param name  The name of the product.
     * @param price The price of the product.
     */
    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}

/**
 * Represents a shopping cart that holds products and their quantities.
 */
class Cart {
    private Map<Product, Integer> products;
    private NumberFormat frFormat;

    /**
     * Constructs a new, empty Cart.
     */
    public Cart() {
        this.products = new HashMap<>();
        frFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    }

    /**
     * Gets the quantity of a specific product in the cart.
     *
     * @param product The product to check.
     * @return The quantity of the product, or null if the product is not in the cart.
     */
    public Integer getProduct(Product product) {
        return this.products.get(product);
    }

    /**
     * Gets the quantity of a product in the cart by its name.
     *
     * @param productName The name of the product.
     * @return The quantity of the product, or null if the product is not in the cart.
     */
    public Integer getProduct(String productName) {
        Product product = this.getProductByItsName(productName);
        return this.products.get(product);
    }

    /**
     * Prints the contents of the cart, including product names, prices, quantities, and subtotals.
     */
    public void printCart() {
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            Product p = entry.getKey();
            Double sb = p.getPrice() * entry.getValue();
            System.out.printf("%s: Price: %s  Quantity: %d  Subtotal: %s %n",
                    p.getName(),
                    frFormat.format(p.getPrice()),
                    entry.getValue(),
                    frFormat.format(sb));
        }
        System.out.printf("Total : %s", frFormat.format(this.getTotal()));
    }

    /**
     * Calculates the total price of all products in the cart.
     *
     * @return The total price.
     */
    public double getTotal() {
        double total = 0.00;
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            Product p = entry.getKey();
            double sb = p.getPrice() * entry.getValue();
            total += sb;
        }
        return total;
    }

    /**
     * Adds a product to the cart. If the product is already in the cart, its quantity is increased by 1.
     *
     * @param product The product to add.
     * @return true if the product was added or its quantity was increased.
     */
    public boolean addProduct(Product product) {
        Integer currentQt = this.products.get(product);
        if (currentQt == null) {
            this.products.put(product, 1);
        } else {
            this.products.replace(product, currentQt + 1);
        }
        return true;
    }

    /**
     * Removes a product from the cart.
     *
     * @param product The product to remove.
     * @return true if the product was removed, false if the product was not in the cart.
     */
    public boolean removeProduct(Product product) {
        Integer currentQt = this.products.get(product);
        if (currentQt == null) {
            System.out.println("No such product in your cart.");
            return false;
        } else {
            this.products.remove(product);
        }
        return true;
    }

    /**
     * Decreases the quantity of a product in the cart by the specified amount.
     *
     * @param name The name of the product.
     * @param qty  The amount to decrease the quantity by.
     * @return true if the quantity was decreased, false if the product was not in the cart.
     */
    public boolean decreaseProductQuantity(String name, Integer qty) {
        Product product = getProductByItsName(name);
        if (product == null) {
            System.out.println("No " + name + " in your cart");
            return false;
        }
        this.products.put(product, this.products.get(product) - qty);
        return true;
    }

    /**
     * Increases the quantity of a product in the cart by the specified amount.
     *
     * @param name The name of the product.
     * @param qty  The amount to increase the quantity by.
     * @return true if the quantity was increased, false if the product was not in the cart.
     */
    public boolean increaseProductQuantity(String name, Integer qty) {
        Product product = getProductByItsName(name);
        if (product == null) {
            System.out.println("No " + name + " in your cart");
            return false;
        }
        this.products.put(product, this.products.get(product) + qty);
        return true;
    }

    /**
     * Finds a product in the cart by its name.
     *
     * @param name The name of the product to find.
     * @return The product if found, null otherwise.
     */
    public Product getProductByItsName(String name) {
        for (Product product : this.products.keySet()) {
            if (product.getName().contains(name)) {
                return product;
            }
        }
        return null;
    }
}

/**
 * Represents a user with a shopping cart.
 */
class User {
    private String name;
    private Cart cart;

    /**
     * Constructs a new User with the given name and an empty cart.
     *
     * @param name The name of the user.
     */
    public User(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    /**
     * Gets the user's cart.
     *
     * @return The user's cart.
     */
    public Cart getCart() {
        return cart;
    }
}
