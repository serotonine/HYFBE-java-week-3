package polymorphism.exercises;

/**
 1. Create a Calculator class.
 2. Add overloaded add() methods:
      - add(int a, int b)
      - add(double a, double b)
      - add(int a, int b, int c)
 3. Test them in main().
*/
public class Calculator
{
    public static void main(String[] args) {
        System.out.printf("%d + %d = %d%n", 15, 20, add(15, 20));
        System.out.printf("%.2f + %.2f = %.2f%n", 15.99, 20.99, add(15.99, 20.99));
        System.out.printf("%d + %d + %d = %d%n", 15, 20,30, add(15, 20, 30));

    }

    public static int add(int a, int b){
        return a + b;
    }
    public static double add(double a, double b){
        return a + b;
    }
    public static int  add(int a, int b, int c){
        return a + b + c;
    }
}
