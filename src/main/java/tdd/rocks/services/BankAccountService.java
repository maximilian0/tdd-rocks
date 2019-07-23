package tdd.rocks.services;

import org.springframework.stereotype.Service;
import tdd.rocks.domain.BankAccount;
import tdd.rocks.domain.BankAccountBalance;

@Service
public class BankAccountService {

    public BankAccountBalance getBalance(String accountNumber) {
        return BankAccount.REPOSITORY.get(accountNumber).getBalance();
    }
}
