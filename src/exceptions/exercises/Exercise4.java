package exceptions.exercises;

/**
 *  Exercise 4:
 *  Parse a string into an integer.
 *  If the string is not a number (e.g., "abc"),
 *  catch NumberFormatException.
 */

public class Exercise4 
{
    public static void main(String[] args)
    {
        String text = "123"; // "abc";  // try with "123"
        int result = 0;
        try{
            result = Integer.parseInt(text);
        }
        catch(NumberFormatException e){
            System.out.println(e.toString());
        }
        finally{
            System.out.println("The result is : " + result);
        }

    }

}




