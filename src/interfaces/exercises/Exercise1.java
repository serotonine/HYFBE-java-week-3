package interfaces.exercises;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO AGAIN:
 * Exercise 1:
 * Create a Student class with name and grade.
 * Implement Comparable<Student> so that students are sorted by grade.
 * In main(), add some students to a List and sort them using Collections.sort().
 * Print the sorted list.
 * Note : Comparable<T> interface (built-in in Java).
 */

public class Exercise1
{

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>(Arrays.asList(
                new Student("Gaspard", 5),
                new Student("Mamoud", 25),
                new Student("Seccotine", 67),
                new Student("Jon", 29),
                new Student("Preeti", 55),
                new Student("Oliver", 67),
                new Student("Roberta", 90)
        ));
       Collections.sort(students);
       students.forEach(student -> student.getInfo());
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int grade;
    public Student(String name, int grade){
        this.name=name;
        this.grade=grade;
    }
    public int getGrade(){
        return this.grade;
    }

    public String getName() {
        return this.name;
    }
    public void getInfo(){
       System.out.println(name + " grade: " + grade);
    }

    public int compareTo(Student alter) {
        return Integer.compare(this.grade, alter.grade);
    }

}