package encapsulation.exercises;

public class Main {
    public static void main(String[] args) {
        System.out.println("/// EMPLOYEE ///");
        Employee hr = new Employee("Mrs Jones", 5500);
        System.out.printf("Employee name: %s%n", hr.getName());
        hr.giveRaise(-500.00);
        System.out.printf("Employee salary: %.2f%n", hr.getSalary());
        System.out.println("/// RECTANGLE ///");
        Rectangle myRec = new Rectangle(15.00, 3.5);
        System.out.printf("Area: %.2f%n", myRec.getArea());
        System.out.printf("Perimeter: %.2f%n", myRec.getPerimeter());
        myRec.setWidth(-5);
        System.out.println("/// SHOPPING CARD ///");
        ShoppingCart mySp = new ShoppingCart();
        mySp.addItem("Socks", 4.99);
        mySp.addItem("T-shirt", 20.99);
        mySp.addItem("Trousers", 149.99);
        mySp.getItems();
        System.out.printf("%nTotal: %15.2f €%n", mySp.getTotalPrice());
        mySp.removeItem("Trousers");
        mySp.getItems();
        System.out.println("/// TEMPERATURE ///");
        Temperature myTemp = new Temperature();
        myTemp.setTemperatureInCelsius(34.00);
        System.out.println("Temperature: " + myTemp.getTemperatureInCelsius()+"°C");
        myTemp.setTemperatureInCelsius(-273.00);
        myTemp.getFahrenheit();
        myTemp.getKelvin();


    }
}
