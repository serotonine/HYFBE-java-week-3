package inheritance.exercises;

/**
 1. Create a superclass Animal with:
      - method makeSound() → prints "Some sound...".
 2. Create subclasses Dog and Cat that override makeSound().
 3. In main(), create a Dog and Cat and call their makeSound().
*/

public class Animal
{
    public void makeSound(){
        System.out.println("Animal makes sound.");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Cat barks.");
    }
}