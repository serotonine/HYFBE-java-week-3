package interfaces.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO:
 * Exercise 2:
 * Define an interface Payment with a method pay(double amount).
 * Implement classes: PaypalPayment, BankTransferPayment.
 * Each class should print a custom payment message.
 * Write a Demo that processes both payments.
 */

interface Payment
{
    double pay(double amount);
}
public class Exercise2 {

    public double balance = 1000;

    public static void main(String[] args) {
        double balance = 1000.00;
        List<Payment> payments = new ArrayList<>(Arrays.asList( new BankTransferPayment(balance), new PayPalPayment(balance)));
        for (Payment payment : payments) {
            payment.pay(250);
        }
    }
}

class BankTransferPayment implements Payment {

    double balance;
    public BankTransferPayment(double balance){
        this.balance = balance;
    }
    public double pay(double amount) {
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

        return balance;
    }
}

class PayPalPayment implements Payment {
    double balance;
    public PayPalPayment(double balance){
        this.balance = balance;
    }

    public double pay(double amount) {
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
        return balance;
    }
}

