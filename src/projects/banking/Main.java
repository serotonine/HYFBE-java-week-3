package projects.banking;
/*
2. **Banking Application** 💰
    * Classes: `BankAccount`, `CheckingAccount`, `SavingsAccount`.
    * Use **inheritance** for account types.
    * **Encapsulation** for balance (private + getters/setters).
    * Store accounts in a `Map<String, BankAccount>`.
 */

import constructors.exercises.BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Map<String,BankAccountBis> accounts = new HashMap<>();
        accounts.put("Serotonine",new SavingsAccount("Serotonine", 7890.00, 0.2));
        accounts.put("Bob",new CheckingAccount("Bob", 10000.00));
        accounts.put("Momo",new CheckingAccount("Momo", 300.00));
        for(BankAccountBis account:accounts.values()){
            try{
               /* account.add(random.nextDouble(20,50));
                account.add(-40);*/
                account.withdraw(random.nextDouble(200,10000));
                account.withdraw(random.nextDouble(200,10000));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }
            try{
               /* account.add(random.nextDouble(20,50));
                account.add(-40);*/
                account.withdraw(random.nextDouble(200,10000));
                account.withdraw(random.nextDouble(200,10000));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }
            try{
               /* account.add(random.nextDouble(20,50));
                account.add(-40);*/
                account.withdraw(random.nextDouble(200,10000));
                account.withdraw(random.nextDouble(200,10000));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }


            account.printTransactions();
        }


        }

}

abstract class BankAccountBis{
    private User user;
    private double balance;
    private List<String> transactions;
    public BankAccountBis(String userName, double balance){
        this.user = new User(userName);
        this.balance = balance;
        transactions = new ArrayList<>();
        transactions.add("add " + balance);
    }
    public void add(double amount){
        if(amount <= 0 ){
            throw new IllegalArgumentException(this.user.getName() + ": Null or negative amount are not allowed");
        }
        this.balance += amount;
        transactions.add("add " + amount);
    };
    public void withdraw(double amount){
        if(amount == 0 ){
            throw new IllegalArgumentException(this.user.getName() + ": Null amount is not allowed");
        }
        if(amount > balance){
            throw new IllegalArgumentException(this.user.getName() + ": The amount override your balance");
        }
        this.balance -= Math.abs(amount);
        transactions.add("sub " + amount);
    };
    public User getUser(){
        return this.user;
    };
    public double getBalance(){
        return this.balance;
    };
    public void printTransactions(){
        for(String transaction:transactions){
            printTransactionRow(transaction);
        }
        printTransactionBalance(this.getBalance());
    }
    protected void printTransactionRow(String row){
        // Cast to double.
        Double d = Double.parseDouble(row.substring(3));
        if(row.substring(0,3).equals("add")){
            System.out.printf("+%20.2f%n",d);
        }
        else {
            System.out.printf("-%20.2f%n",d);
        }
    }
    protected void printTransactionBalance(double amount){
        System.out.printf("Total: %14.2f%n",amount);
    }
}

class CheckingAccount extends BankAccountBis{

    public CheckingAccount(String userName, double balance) {
        super(userName, balance);
    }
}
class SavingsAccount extends BankAccountBis{
    double interest;
    public SavingsAccount(String userName, double balance, double interest) {
        super(userName, balance);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }
    public double getFinalBalance(){
        return this.getBalance() + (this.getBalance() * (this.getInterest() / 100));
    }

    @Override
    public void printTransactions() {
        super.printTransactions();
        System.out.printf("Interest: %9.2f%s%n",this.getInterest(), " %");
        printTransactionBalance(this.getFinalBalance());
    }
}