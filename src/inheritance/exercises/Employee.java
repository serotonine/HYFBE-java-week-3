package inheritance.exercises;

/**
 TODO:
 1. Create a superclass Employee with:
      - name (String), salary (double).
      - method work() → prints "<name> is working".
 2. Create subclasses Developer and Manager:
      - Developer overrides work() → prints "<name> is writing code".
      - Manager overrides work() → prints "<name> is managing the team".
 3. Test both in a main class.
*/


public class Employee
{
    String name;
    double salary;

    public Employee(){
        this("No name", 00.00);
    }
    public Employee(String name, double salary){
       this.name = name;
       this.salary = salary;
    }
    public void work(){
        System.out.println(this.name + " is working");
    }
}

class Developer extends Employee{
    public Developer(String name, double salary){
        super(name, salary);
    }
    @Override
    public void work() {
        super.work();
        System.out.println("I'm a developer I type endless lines of codes while eating pizzas and chips.");
    }
}

class Manager extends Employee{
    public Manager(String name, double salary){
        super(name, salary);
    }
    @Override
    public void work() {
        super.work();
        System.out.println("I'm a manager I love judging and directing workers while I'm joking with my pairs.");
    }
}
