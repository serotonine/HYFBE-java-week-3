package constructors.exercises;

/**
 1. Create class BankAccount with:
      - private fields accountNumber, balance
      - private static field accountCount
 2. Add constructors:
      - Default constructor → sets accountNumber="0000", balance=0
      - Parameterized constructor → sets accountNumber and balance
 3. Increment accountCount whenever a new account is created.
 4. Add methods deposit(), withdraw(), getBalance().
 5. Add static method getTotalAccounts().
 6. Test creating multiple accounts and check total accounts.
*/

public class BankAccount
{
    private static int accountCount = 0;
    private int id;
    private String accountNumber;
    private double balance;

    public BankAccount(){
        this("Nobody", 0);
    }
    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.id = ++accountCount;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public static int getTotalAccounts(){
       return accountCount;
    }

    public void deposit(double money) {
        this.balance += Math.abs(money);
        System.out.printf("Dear %s, %.2f added. Your balance is now: %.2f %n",  this.accountNumber, money, this.balance);
    }
    public void withdraw(double money){
        if(money >  this.balance){
            System.out.printf("OPERATION NOT PERMITTED%n%.2f is more than your balance: %.2f %n", money, this.balance);
            return;
        }
        this.balance -= Math.abs(money);
        System.out.printf("Dear %s, %.2f withdrew. Your balance is now: %.2f %n", this.accountNumber, money, this.balance);

    }
}
