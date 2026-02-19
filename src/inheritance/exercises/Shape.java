package inheritance.exercises;

/**
 TODO:
 1. Create superclass Shape with method getArea().
 2. Create subclasses Circle and Rectangle:
      - Circle has radius.
      - Rectangle has width and height.
 3. Override getArea() in each subclass.
 4. In main(), create both and print their areas.
*/


public class Shape
{
    public double getArea(){
        return 0;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
