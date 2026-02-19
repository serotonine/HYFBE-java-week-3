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
        // Makes value mutable.
        grades.put("Germaine",new ArrayList<>(Arrays.asList(45,55,78,23)));
        grades.put("Robert",new ArrayList<>(Arrays.asList(45,13,51,12) ));
        grades.put("Pretti",new ArrayList<>(Arrays.asList(75,86,78,65)) );
        grades.put("Fatima",new ArrayList<>(Arrays.asList(95,55,90,67) ));
        grades.put("Momo",new ArrayList<>(Arrays.asList(45,40,55,65) ));
        grades.get("Momo").add(65);
        System.out.println(grades);
        printAverageGradeByStudent(grades);
    }
    public static void printAverageGradeByStudent(Map<String, List<Integer>> grades){
        grades.forEach((student, list)->{
            int total = 0;
            for(int val:list){
                total += val;
            }
            // int sum = list.stream().reduce(0, Integer::sum);
            double average =  (double)(total / list.size());
            System.out.println(student +": "+average+" % success");
        });
    }
}
