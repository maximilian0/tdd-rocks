package tdd.rocks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
public class BankAccountBalance {

    private BigDecimal amount;
    private String currency;
}
