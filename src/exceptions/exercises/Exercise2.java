package exceptions.exercises;

import java.lang.reflect.Array;

/**
 *  Exercise 2:
 *  Create an array of 5 elements.
 *  Try to access index 10.
 *  Catch ArrayIndexOutOfBoundsException and print a message.
 */

public class Exercise2
{
    public static void main(String[] args) {
        int[] myArray = new int[5];
        try{
           for(int i =0; i<=myArray.length; i++){
               System.out.println(i + "=> " + myArray[i]);
           }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
        finally{
            System.out.println("\nThat's all folks!");
        }
    }
}
