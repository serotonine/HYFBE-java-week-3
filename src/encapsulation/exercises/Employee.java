package encapsulation.exercises;

/**
 1. Create private fields: name (String), salary (double).
 2. Write a constructor to initialize both.
 3. Add getters for both fields.
 4. Add a setter for salary that does NOT allow negative values.
 5. Create a method giveRaise(double amount) that increases salary.
 */
public class Employee
{
    String name;
    double salary;
    public Employee(){
        this("Nobody", 0.00);
    }
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
            return this.salary;
    }
    public void setSalary(double salary){
        if(salary > 0){
            this.salary = salary;
        }
        else{
            System.out.println("Salary could not be negative.");
        }
    }

    public String getName() {
        return this.name;
    }
    public void giveRaise(double amount){
        try{
            if(amount > 0){
                this.salary += amount;
            }
            else{
                throw new Exception("Amount could not be negative.");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
