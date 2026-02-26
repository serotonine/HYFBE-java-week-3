package projects.zoo;
/*
5. **Zoo Management System** 🦁🐒🐧

    * Abstract class: `Animal` (method `makeSound()`).
    * Subclasses: `Lion`, `Monkey`, `Penguin`.
    * Store animals in a `List<Animal>` (demonstrating **polymorphism**).
    * Features: feed animals, display zoo inventory.
 */

import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Monkey("Robert"));
        animals.add(new Lion("King"));
        animals.add(new Penguin("Alexandra"));
        displayZooInventory(animals);
    }

    public static void displayZooInventory(ArrayList<Animal> animals){
        for(Animal animal:animals){
            animal.printSpecie();
            System.out.println(animal.getName() + "'s biotope: " + animal.getBiotope());
            animal.eat("Fruits");
            animal.eat("Meat");
            animal.eat("Fish");
            System.out.println("\n");
        }
    }
}


