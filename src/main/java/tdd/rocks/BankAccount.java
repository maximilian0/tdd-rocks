package tdd.rocks;

public class BankAccount {

    private String balance;

    public BankAccount(String balance) {
        this.balance = balance;
    }

    public String getBalanceInPesos() {
        return balance;
    }
}
