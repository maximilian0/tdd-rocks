package tdd.rocks;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class BankAccount {

    private BigDecimal amount;
    private String currency;

    public BankAccountBalance getBalance() {
        return new BankAccountBalance(amount, currency);
    }

    public BankAccountBalance getBalance(BigDecimal ratio, String currency) {
        if (currency.equals(this.currency))
            return this.getBalance();
        return new BankAccountBalance(amount.divide(ratio, 2, RoundingMode.UP), currency);
    }

    public BankAccountBalance deposit(BigDecimal deposit) {
        amount = amount.add(deposit);
        return new BankAccountBalance(amount, currency);
    }

    public BankAccountBalance withdraw(BigDecimal withdraw) throws InsufficientFundsException {
        if (this.hasFundsToWithdraw(withdraw)) {
            throw new InsufficientFundsException();
        }
        amount = amount.subtract(withdraw);
        return new BankAccountBalance(amount, currency);
    }

    private boolean hasFundsToWithdraw(BigDecimal withdraw) {
        return withdraw.compareTo(amount) > 0;
    }
}