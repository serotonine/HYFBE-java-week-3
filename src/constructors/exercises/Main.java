package constructors.exercises;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("/// Class BankAccount ///");
        BankAccount poorBoy = new BankAccount();
        BankAccount richGirl = new BankAccount("Rich Girl", 3500.75);
        System.out.println("Total accounts = " + BankAccount.getTotalAccounts());
        poorBoy.deposit(10);
        richGirl.deposit(34000);
        System.out.println("Poor boy balance = " + poorBoy.getBalance());
        System.out.println("Rich girl balance = " + richGirl.getBalance());
        poorBoy.withdraw(15);
        richGirl.withdraw(1000.55);
        poorBoy.deposit(1000.55);
        poorBoy.setAccountNumber("Not so Poor Boy");
        poorBoy.withdraw(15);
        System.out.println("/// Class Car ///");
        Car volvo = new Car("Volvo", 1950);
        Car schieve = new Car();
        schieve.printCarInfo();
        volvo.printCarInfo();
        System.out.println("/// Class Rectangle ///");
        Rectangle myRectangle = new Rectangle(10, 50);
        System.out.println("Area = " + myRectangle.getArea());
        System.out.println("Perimeter = " + myRectangle.getPerimeter());
        System.out.println("/// Class Student ///");
        Map<String, Student> students = new HashMap<>();
        String[] studentNames = new String[]{"Alisan", "Andrei", "Basel", "Carles", "Catherine", "Elena", "Gomathi", "Preeti", "Jon", "Kien", "Julie"};
        for (String name : studentNames) {
            students.put(name, new Student(name));
        }
        students.forEach((String key, Student obj) -> {
            obj.getStudentInfo();
        });
        System.out.println("How many students ? " + Student.getTotalStudents());
    }
}
