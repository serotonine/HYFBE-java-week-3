package inheritance.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("// ANIMAL //");
        List<Animal> animals = new ArrayList<>(Arrays.asList(new Cat(), new Dog()));
        animals.forEach(animal-> animal.makeSound());
        System.out.println("// EMPLOYEE //");
       List<Employee> employees = new ArrayList<>(Arrays.asList(new Developer("Robert", 3000.00), new Manager("Bob the Indian", 5000.00)));
        employees.forEach(employee-> employee.work());
        System.out.println("// SHAPE //");
        Circle myCircle = new Circle(5.00);
        Rectangle myRect = new Rectangle(10.00,5.00);
        System.out.println("My Rectangle area: " + myRect.getArea());
        System.out.println("My Circle area: " + String.format("%.2f", myCircle.getArea()));
    }
}
