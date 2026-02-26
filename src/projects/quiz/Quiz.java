package projects.quiz;
/*
9. **Online Quiz System**

    * Classes: `Question`, `ChoiceQuestion`, `TrueFalseQuestion`.
    * Store questions in a `List<Question>`.
    * Use **polymorphism**: `displayQuestion()` overridden in each subclass.
    * Features: ask questions, check answers, calculate score.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        // Questions sur SOLID
        questions.add(new TrueFalseQuestion(
                "The Single Responsibility Principle (SRP) states that a class should have only one reason to change.",
                "y"
        ));

        questions.add(new TrueFalseQuestion(
                "The Open/Closed Principle (OCP) states that software entities should be closed for extension but open for modification.",
                "n"
        ));

        questions.add(new ChoiceQuestion(
                "Which principle states that objects in a program should be replaceable with instances of their subtypes without altering the correctness of the program?",
                "3",
                new String[]{
                        "Single Responsibility Principle (SRP)",
                        "Open/Closed Principle (OCP)",
                        "Liskov Substitution Principle (LSP)",
                        "Interface Segregation Principle (ISP)"
                }
        ));

        questions.add(new ChoiceQuestion(
                "Which principle encourages many client-specific interfaces rather than one general-purpose interface?",
                "4",
                new String[]{
                        "Single Responsibility Principle (SRP)",
                        "Open/Closed Principle (OCP)",
                        "Liskov Substitution Principle (LSP)",
                        "Interface Segregation Principle (ISP)"
                }
        ));

        questions.add(new TrueFalseQuestion(
                "Dependency Inversion Principle (DIP) suggests that high-level modules should not depend on low-level modules, but both should depend on abstractions.",
                "y"
        ));

        questions.add(new ChoiceQuestion(
                "What is the main goal of the Single Responsibility Principle (SRP)?",
                "1",
                new String[]{
                        "To ensure a class has only one responsibility",
                        "To make classes open for extension but closed for modification",
                        "To allow substitution of parent classes with child classes",
                        "To reduce the number of interfaces in a system"
                }
        ));

        questions.add(new ChoiceQuestion(
                "Which SOLID principle is violated if a class has too many responsibilities?",
                "3",
                new String[]{
                        "Open/Closed Principle (OCP)",
                        "Liskov Substitution Principle (LSP)",
                        "Single Responsibility Principle (SRP)",
                        "Dependency Inversion Principle (DIP)"
                }

        ));

        questions.add(new TrueFalseQuestion(
                "The Liskov Substitution Principle (LSP) is primarily concerned with inheritance and polymorphism.",
                "y"
        ));

        questions.add(new ChoiceQuestion(
                "Which principle is violated if a class depends directly on another concrete class?",
                "4",
                new String[]{
                        "Single Responsibility Principle (SRP)",
                        "Open/Closed Principle (OCP)",
                        "Liskov Substitution Principle (LSP)",
                        "Dependency Inversion Principle (DIP)"
                }

        ));

        questions.add(new ChoiceQuestion(
                "What is the benefit of following the Open/Closed Principle (OCP)?",
                "2",
                new String[]{
                        "It reduces the need for testing",
                        "It allows extending functionality without modifying existing code",
                        "It ensures all classes have only one responsibility",
                        "It eliminates the need for interfaces"
                }

        ));
        int score = 0;
        int count = 0;
        while(count<questions.size()){
            Question q = questions.get(count);
            System.out.println(q.getQuestion());
            String response  = scanner.nextLine();
            if(q.checkResponse(response)){
                System.out.println("Good!");
                score++;
            }
            else{
                System.out.println("Bad!");
            }

            count++;

        }
        scanner.close();
        System.out.println("Score = " + score+"/"+questions.size());
    }
}

class ChoiceQuestion extends Question{

    private String[] choices;
    public ChoiceQuestion(String question, String response, String[] choices){
        super(question, response);
        this.choices = choices;
    }
    public String getQuestion() {

        String output = this.question;
        int i = 1;
        for(String q:this.choices){
            output += "\n" + i +". " + q;
            i++;
        }
        return output;
    }
}

class TrueFalseQuestion extends Question {
    private String question;
    private String response;
    public TrueFalseQuestion(String question, String response){
        super(question.concat(" (y - n)") ,response );
    }
}

class Question{
    protected String question;
    private String response;
    public Question(String question, String response){
        this.question = question;
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }
    public boolean checkResponse(String response){
        return (response.trim().toLowerCase()).contentEquals(this.response);
    }
}