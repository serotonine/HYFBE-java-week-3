package composition.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 1. Create class Employee with fields: name, role.
 2. Create class Department that HAS-A List<Employee>.
 3. Create class Company that HAS-A List<Department>.
 4. Add methods to:
      - Add employee to a department
      - List employees by department
 5. Test with multiple departments and employees.
*/

class Department
{
    private final List<Employee> employees;
    String departmentName;
    public Department(String departmentName){
        this.employees = new ArrayList<>();
        this.departmentName = departmentName;
    }
    public void hire(String name, String role){
        this.employees.add(new Employee(name, role));
        System.out.println(name + " has been hired as " + role);
    }


    public void listEmployees(){
        for(Employee employee: this.employees){
            System.out.println(employee.getName() + " : " + employee.getRole());
        }
    }
}


class Employee
{
    private String name;
    private String role;

    public Employee(){
        this("Anonymous", "internship");
    }
    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }
    public String getName(){
        return this.name;
    }
    public String getRole(){
        return this.role;
    }
}
