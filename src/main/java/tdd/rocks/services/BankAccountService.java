package tdd.rocks.services;

import org.springframework.stereotype.Service;
import tdd.rocks.domain.BankAccount;
import tdd.rocks.domain.BankAccountBalance;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class BankAccountService {

    public BankAccountBalance getBalance(String accountNumber) {
        return BankAccount.REPOSITORY.get(accountNumber).getBalance();
    }

    public BankAccountBalance postDeposit(String accountNumber, Map<String, Object> body) {
        return BankAccount.REPOSITORY.get(accountNumber).deposit(BigDecimal.valueOf((Integer) body.get("amount")));
    }
}