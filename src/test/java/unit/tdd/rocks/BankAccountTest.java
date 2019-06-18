package unit.tdd.rocks;

import org.junit.Test;
import tdd.rocks.BankAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BankAccountTest {

    /**
     * As a client who own an account in Plaza Bank
     * when I ask for my account balance in pesos
     * I want to know my account summarized balance
     **/

    @Test
    public void testGetBalance10Pesos() {
        // | final_balance |
        // | 10 pesos      |

        BankAccount account = new BankAccount("10 pesos");

        String balance = account.getBalanceInPesos();

        assertNotNull(balance);
        assertEquals("10 pesos", balance);
    }

    @Test
    public void testGetBalance0Pesos() {
        // | final_balance |
        // | 0 pesos       |

        BankAccount account = new BankAccount("0 pesos");

        String balance = account.getBalanceInPesos();

        assertNotNull(balance);
        assertEquals("0 pesos", balance);
    }
}
