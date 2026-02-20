package exceptions.exercises;

/**
 * Exercise 1:
 * Write a program that divides two numbers.
 * Catch ArithmeticException when dividing by zero.
 * Print a friendly error message.
 */

public class Exercise1
{
    public static void main(String[] args)
    {
        System.out.println(divide(10, 5));
        System.out.println(divide(10, 0));

    }

   static double divide(int a,int b){
        double result = 0;
        try{
           result =  a/b;
        }
        catch(ArithmeticException e){
            System.out.println(e.toString());
        }
        finally{
            System.out.println("Result:");
            return result;
        }

    }
}




