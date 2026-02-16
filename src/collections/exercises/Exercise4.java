package collections.exercises;

import java.util.*;

/**
 1. Create a Map<String, List<Integer>> grades.
    - Key = student name
    - Value = list of grades
 2. Add at least 3 students with multiple grades each.
 3. Print all students with their grades.
 4. Calculate and print the average grade for each student.
*/

public class Exercise4
{
    public static void main(String[] args) {
        Map<String, List<Integer>> grades = new HashMap<>();
        grades.put("Germaine",populateGrades(new int[]{45,55,78,23}) );
        grades.put("Robert",populateGrades(new int[]{45,13,51,12}) );
        grades.put("Pretti",populateGrades(new int[]{75,86,78,65}) );
        grades.put("Fatima",populateGrades(new int[]{95,55,90,67}) );
        grades.put("Momo",populateGrades(new int[]{45,40,55,65}) );
        System.out.println(grades);
        printAverageGradeByStudent(grades);
    }
    public static List populateGrades(int[] grades){
        List<Integer> _grades = new ArrayList<>();
        for(int grade:grades){
            _grades.add(grade);
        }
    return _grades;
    }

    public static void printAverageGradeByStudent(Map<String, List<Integer>> grades){
        grades.forEach((student, list)->{
            int sum = list.stream().reduce(0, Integer::sum);
            int average =  sum / list.size();
            System.out.println(student +": "+average+"% success");
        });
    }
}
