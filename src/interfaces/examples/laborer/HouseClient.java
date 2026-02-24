package interfaces.examples.laborer;


interface Door {
    void build();
}

class WoodenDoor implements Door {
    public void build() {
        System.out.println("Building a wooden door");
    }
}

class SteelDoor implements Door {
    public void build() {
        System.out.println("Building a steel door");
    }
}

interface Paint {
    void apply();
}
class RedPaint implements Paint {
    public void apply() {
        System.out.println("Painting with red color");
    }
}

class BluePaint implements Paint {
    public void apply() {
        System.out.println("Painting with blue color");
    }
}

class Laborer {

    private final Door door;
    private final Paint paint;

    public Laborer(Door door, Paint paint) {
        this.door = door;
        this.paint = paint;
    }

    public void produce() {
        door.build();
        paint.apply();
    }
}

public class HouseClient {
    public static void main(String[] args) {

        //There are different types of paint and doors, they are interchangable, they are decided on runtime, this is Strategy pattern

        Laborer maker1 =
                new Laborer(new WoodenDoor(), new RedPaint());        //This is dependency injection
        //private Door door = new WoodenDoor(); // this is hard coded, tightly coupled

        Laborer maker2 =
                new Laborer(new SteelDoor(), new BluePaint());

        /*
            Dependency Injection is a technique.
            Strategy is a design pattern.
            DI is often used to implement Strategy.
         */

        maker1.produce();
        maker2.produce();

        /*
            Dependency Inversion Principle
            High-level modules should not depend on low-level modules.
            Both should depend on abstractions.



            Abstractions should not depend on details.
            Details should depend on abstractions.
         */
    }
}
