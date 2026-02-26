package projects.library;

/*
Steps to Calculate the Check Digit (ISBN-10)
Multiply each digit (from 1 to 9) by its weight (from 10 to 2):
The first digit is multiplied by 10,
the second digit by 9, the third digit by 8... the ninth digit by 2.
Sum all these products.
Find the remainder of this sum when divided by 11.
Check digit rules:

If the remainder is 0, the check digit is 0.
Otherwise, the check digit is 11 - remainder.
If the check digit is 10, use the letter X.

Example
ISBN 0-306-40615-?
 the check digit is calculated as 2
 resulting in 0-306-40615-2.
 If the remainder were 1, the check digit would be X.
 */

import java.util.Random;

/**
 * Generates a random valid ISBN-10 number.
 *
 * @return A valid ISBN-10 string in the format X-XXX-XXXXX-X.
 */
class IsbnUtil{
    final static Random random = new Random();
    public static String getIsbn(){
        StringBuilder isbn = new StringBuilder();
        int sum = 0;
        int[] numbers = new int[9];

        for (int i = 0; i<9; i++){
            numbers[i] = random.nextInt(10);
            isbn.append(numbers[i]);
            sum += numbers[i] * (10 - i);
        }
        int modulo = sum % 11;
        int lastNumber = modulo == 0 ? 0 : 11 - modulo;
        String last = lastNumber == 10 ? "X" : Integer.toString(lastNumber);
        isbn.append(last);

        isbn.insert(1, '-').insert(5,'-').insert(isbn.length() -1, '-');

        return isbn.toString();
    }
}
