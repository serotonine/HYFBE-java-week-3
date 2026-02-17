package constructors.exercises;

/**
 TODO:
 1. Create class Student with:
      - private field name
      - private static field studentCount
 2. Each new Student should get a unique ID (increment studentCount).
 3. Add a method getStudentInfo() to print name and ID.
 4. Add a static method getTotalStudents().
*/

public class Student
{
    private String name;
    private static int studentCount= 0;
    private int id;

    public Student(){
        this("Nobody");
    }
    public Student(String name){
        this.name = name;
        id = ++studentCount;
    }
    public void getStudentInfo(){
        System.out.printf("Student name: %s - student id: %d%n", this.name, this.id);
    }
    public static int getTotalStudents(){
        return studentCount;
    }
}
