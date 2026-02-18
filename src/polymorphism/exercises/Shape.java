package polymorphism.exercises;

import java.util.List;

/**
 1. Create abstract class Shape with method draw().
 2. Create subclasses Circle, Rectangle, Triangle → each overrides draw().
 3. Store them in a List<Shape> and loop through to call draw().
*/

abstract class Shape
{
    public void draw(){}
}

class Main{
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(), new Rectangle(), new Triangle());
        for(Shape shape:shapes){
            shape.draw();
        }

    }
}

class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle draw method.");
    }
}
class Rectangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle draw method.");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Triangle draw method.");
    }
}