package polymorphism.exercises;

import java.util.List;

/**
 1. Create a superclass Payment with method pay(double amount).
 2. Create subclasses:
      - CreditCardPayment (prints "Paid <amount> using Credit Card").
      - PayPalPayment (prints "Paid <amount> using PayPal").
      - CashPayment (prints "Paid <amount> in cash").
 3. In main():
      - Create a List<Payment>.
      - Add different payment types.
      - Loop and call pay() → each behaves differently.
*/


public class Payment
{ 
    public static double balance = 1000;
   /* public Payment(double balance){
        balance = balance;
    }*/
    public static void main(String[] args) {
        double balance = 1000.00;
        List<Payment> payments = List.of(
                new Payment(),
                new CreditCardPayment(),
                new PayPalPayment(),
                new CashPayment()
        );
        for(Payment payment:payments){
            payment.pay(250);
        }
    }
    public Double pay(double amount){

        try{
            if(amount<=balance ){
                balance -= Math.abs(amount);
                System.out.printf("Paid %.2f using payment. Your balance is now %.2f%n", amount, balance);
                return balance;
            }
            else{
                throw new Exception("Your wallet is too low ! Soryyyy!!");
            }
        }
        catch(Exception e ){
            System.out.println(e.toString());
        }

        return null;
    }
    public double getBalance(){
        return balance;
    }
}

// CreditCardPayment (prints "Paid <amount> using Credit Card").
class CreditCardPayment extends Payment{
    /*public CreditCardPayment(double balance){
        super(balance);
    }*/

    @Override
    public Double pay(double amount) {
        try{
            if(amount<=balance ){
                balance -=Math.abs(amount);
                System.out.printf("Paid %.2f using Credit Card. Your balance is now %.2f%n", amount, balance);
            }
            else{
                throw new Exception("Your wallet is too low ! Soryyyy!!");
            }
        }
        catch(Exception e ){
            System.out.println(e.toString());
        }

        return null;
    }
}
// PayPalPayment (prints "Paid <amount> using PayPal").
class PayPalPayment extends Payment{
   /* public PayPalPayment(double balance){
        super(balance);
    }*/

    @Override
    public Double pay(double amount) {
        try{
            if(amount<=balance ){
                balance -= Math.abs(amount);
                System.out.printf("Paid %.2f using PayPal. Your balance is now %.2f%n", amount, balance);
            }
            else{
                throw new Exception("Your wallet is too low ! Soryyyy!!");
            }
        }
        catch(Exception e ){
            System.out.println(e.toString());
        }

        return null;
    }
}
// CashPayment (prints "Paid <amount> in cash").
class CashPayment extends Payment{
   /* public CashPayment(double balance){
        super(balance);
    }*/

    @Override
    public Double pay(double amount) {
        try{
            if(amount<=balance ){
                balance -=Math.abs(amount);
                System.out.printf("Paid %.2f in cash. Your balance is now %.2f%n", amount, balance);
            }
            else{
                throw new Exception("Your wallet is too low ! Soryyyy!!");
            }
        }
        catch(Exception e ){
            System.out.println(e.toString());
        }

        return null;
    }
}
