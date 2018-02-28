package BankAccountApplication;

public class Savings extends Account {
    // List properties specific to savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize setting for the savings properties
    public Savings(String name, String SSN, double initialDeposit) {
        super(name, SSN, initialDeposit);
        acctNumber = "1" + acctNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;
    }

    // Setter for safety deposit key and ID
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    //  Method to show savings information
    public void showInfo(){
        System.out.println("Account Type: Savings");
        super.showInfo();
        System.out.println("\nYour savings account features" +
                            "\nSafety Deposit Box ID: " + safetyDepositBoxID +
                            "\nSafety Deposit Box Key: " + safetyDepositBoxKey);

    }
}
