package exceptions.exercises;

/**
 *  Exercise 5:
 *  Ask for a user’s age (simulate with variable).
 *  If the age is negative, throw and catch a custom InvalidAgeException.
 */

public class Exercise5
{
    public static void main(String[] args)
    {
        int age = -5; // test value
        try{
            checkAge(age);
        }
        catch(InvalidAgeException e){
            System.out.println(e.toString());
        }

        // Check age and handle exception
    }

    static void checkAge(int age) throws InvalidAgeException
    {
        if (age < 0)
        {
            throw new InvalidAgeException("Age cannot be negative!");
        }
    }
}

// Custom exception class
class InvalidAgeException extends Exception
{
    public InvalidAgeException(String message)
    {
        super(message);
    }
}


