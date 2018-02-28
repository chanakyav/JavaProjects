package BankAccountApplication;

public abstract class Account implements IBaseRate{
    // List common properties for savings and checking accounts
    private String name;
    private String SSN;
    private double balance;

    private static int index = 10000;
    protected String acctNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account

    public Account(String name, String SSN, double initialDeposit) {
        this.name = name;
        this.SSN = SSN;
        this.balance = initialDeposit + 100;
        
        // Set account number
        index++;
        this.acctNumber = setAcctNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAcctNumber(){
        String lastTwoDigits = SSN.substring(SSN.length()-2, SSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoDigits + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String destination, double amount){
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + destination);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is: now $" + balance);
    }

    public void showInfo(){
        System.out.println("Name: " + name +
                            "\nAccount Number: " + acctNumber +
                            "\nBalance: $" + balance +
                            "\nRate: " + rate + "%");

    }
}
