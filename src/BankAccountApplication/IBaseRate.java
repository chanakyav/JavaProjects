package BankAccountApplication;

public interface IBaseRate {

    // Write a methods that returns base rate
    default double getBaseRate(){
        return 2.5;
    }
}
