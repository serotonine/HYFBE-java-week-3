package polymorphism.exercises;

import java.util.List;

/**
 1. Create class Animal with method eat() → "This animal eats food".
 2. Create subclasses Dog and Bird:
      - Dog: "The dog eats bones".
      - Bird: "The bird eats seeds".
 3. Test them in main().
*/

public class Animal
{
    public String name;

    public static void main(String[] args) {
        List<Animal> animals = List.of(new Animal("Animal"), new Cat("Minou"), new Dog("Medor"), new Bird("Chip") );
        for(Animal animal:animals){
            animal.eat();
        }
    }
    public Animal(){
        this("No name");
    }
    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void eat(){
        System.out.println("This animal eats food.");
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.name + " eats meat.");
    }
}
class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + " eats bones, meat and carrots.");
    }
}
class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + " eats seeds.");
    }
}
