package tdd.rocks.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
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
