package interfaces.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * TODO:
 * Exercise 3:
 * Create two interfaces: Flyable and Swimmable, each with a method (fly(), swim()).
 * Implement them in classes: Bird (can fly), Fish (can swim), and Duck (can both fly & swim).
 * Test them in Exercise3 class.
 */
interface Flyable{
  default void fly(){
      System.out.println("I can fly");
    };
}
interface Swimmable{
   default void swim(){
       System.out.println("I can swim");
   };
}
interface Named{
    String getName();
}

public class Exercise3
{
    public static void main(String[] args) {
        List<Named> animals = new ArrayList<>(Arrays.asList(new Bird("Tchip"), new Duck("Coincoin"), new Fish("Lovely")));
        for(Named animal:animals){
            System.out.println((animal.getName()).toUpperCase());
            if(animal instanceof Flyable){
                ((Flyable) animal).fly();
            }
            if(animal instanceof Swimmable){
                ((Swimmable) animal).swim();
            }
        }
    }
}
 class Bird implements Named,Flyable{
    String name;
    public Bird(String name){
        this.name = name;
    }
    @Override
     public String getName() {
         return name;
     }
 }

class Fish implements Named,Swimmable{
    String name;
    public Fish(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

}
class Duck implements Named, Flyable, Swimmable{
    String name;
    public Duck(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}