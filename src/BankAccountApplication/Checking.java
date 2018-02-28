package BankAccountApplication;

public class Checking extends Account {
    // List properties specific to common accounts
    private int debitCardNum;
    private int debitCardPIN;

    // Constructor to initialize checking account properties

    public Checking(String name, String SSN, double initialDeposit) {
        super(name, SSN, initialDeposit);
        acctNumber = "2" + acctNumber;
        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * 0.15;
    }

    // List methods specific to checking account
    private void setDebitCard(){
        debitCardNum = (int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        System.out.println("Account Type: Checking");
        super.showInfo();
        System.out.println("\nYour checking account features" +
                            "\nDebit Card Number: " + debitCardNum +
                            "\nDebit Card PIN: " + debitCardPIN);
    }

}
