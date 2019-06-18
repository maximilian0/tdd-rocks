package tdd.rocks;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class BankAccount {

    private BigDecimal amount;
    private String currency;

    public BankAccountBalance getBalance() {
        return new BankAccountBalance(amount, currency);
    }

    public BankAccountBalance deposit(BigDecimal deposit) {
        amount = amount.add(deposit);
        return new BankAccountBalance(amount, currency);
    }
}
