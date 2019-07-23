package tdd.rocks.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
public class BankAccountBalance {

    private BigDecimal amount;
    private String currency;

    @Override
    public String toString() {
        return "BankAccountBalance{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
