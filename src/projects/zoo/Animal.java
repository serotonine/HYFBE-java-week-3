package projects.zoo;
/*
 * Abstract class: `Animal` (method `makeSound()`).
 * Subclasses: `Lion`, `Monkey`, `Penguin`.
 * Store animals in a `List<Animal>` (demonstrating **polymorphism**).
 * Features: feed animals, display zoo inventory.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Animal {
    private final List<String> foods;
    private String name;
    private String biotope;

    public Animal(String[]food, String name, String biotope ){
        this.foods = new ArrayList<>(Arrays.asList(food));
        this.name = name;
        this.biotope = biotope;
    }
    public void makeSound(){
        System.out.println("Animal make a sound");
    }
    public void printSpecie(){
        System.out.println(this.getName() + " is an animal.");

    }
    public void eat(String food){
        if(this.foods.contains(food)){
            System.out.println(this.getName() + " likes eating " + food +".");
        }
        else{
            System.out.println(this.getName() + " does not eat " + food+".");
        }

    }
    public String getName(){
        return this.name;
    }
    public String getBiotope(){
        return this.biotope;
    }

}

class Monkey extends Animal{

    public Monkey(String name) {

        super(new String[]{"Meat", "Fruits", "Roots"}, name,"Jungle");

    }

    @Override
    public void makeSound(){
        System.out.println("Monkey talks");
    }
    @Override
    public void printSpecie(){
        System.out.println(this.getName() + " is a Monkey");
    }
}

class Lion extends Animal{

    public Lion(String name) {

        super(new String[]{"Fish"}, name,"Savana");
    }

    @Override
    public void makeSound(){
        System.out.println("Lion roars");
    }
    @Override
    public void printSpecie(){
        System.out.println(this.getName() + " is a Lion");
    }
}

class Penguin extends Animal{

    public Penguin(String name) {

        super(new String[]{"Fish"}, name,"Antartica");
    }

    @Override
    public void makeSound(){
        System.out.println("Penguin tchip");
    }
    @Override
    public void printSpecie(){
        System.out.println(this.getName() + " is a Penguin");
    }
}


