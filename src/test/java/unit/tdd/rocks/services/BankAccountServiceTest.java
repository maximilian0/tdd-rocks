package unit.tdd.rocks.services;

import org.junit.Test;
import tdd.rocks.domain.BankAccount;
import tdd.rocks.domain.BankAccountBalance;
import tdd.rocks.services.BankAccountService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountServiceTest {

    @Test
    public void testGetBalance() {

        BankAccount account = mock(BankAccount.class);
        when(account.getBalance()).thenReturn(mock(BankAccountBalance.class));
        BankAccount.REPOSITORY.put("1234", account);
        BankAccountService service = new BankAccountService();

        BankAccountBalance balance = service.getBalance("1234");

        assertNotNull(balance);
    }
}
