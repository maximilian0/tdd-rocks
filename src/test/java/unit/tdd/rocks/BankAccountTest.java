package unit.tdd.rocks;

import org.junit.Test;
import tdd.rocks.BankAccount;
import tdd.rocks.BankAccountBalance;
import tdd.rocks.InsufficientFundsException;

import java.math.BigDecimal;

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

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal(10), "pesos");
        BankAccount account = new BankAccount(new BigDecimal(10), "pesos");

        BankAccountBalance balance = account.getBalance();

        assertNotNull(balance);
        assertEquals(expected, balance);
    }

    @Test
    public void testGetBalance0Pesos() {
        // | final_balance |
        // | 0 pesos       |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal(0), "pesos");
        BankAccount account = new BankAccount(new BigDecimal(0), "pesos");

        BankAccountBalance balance = account.getBalance();

        assertNotNull(balance);
        assertEquals(expected, balance);
    }

    @Test
    public void testDeposit15Pesos() {
        //| original_balance | amount  | final_balance |
        //| 10 pesos         | 5 pesos | 15 pesos      |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal(15), "pesos");
        BankAccount account = new BankAccount(new BigDecimal(10), "pesos");

        BankAccountBalance balance = account.deposit(new BigDecimal(5));

        assertNotNull(balance);
        assertEquals(expected, balance);
    }

    @Test
    public void testDeposit5Pesos() {
        //| original_balance | amount  | final_balance |
        //| 0 pesos          | 5 pesos | 5 pesos       |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal(5), "pesos");
        BankAccount account = new BankAccount(new BigDecimal(0), "pesos");

        BankAccountBalance balance = account.deposit(new BigDecimal(5));

        assertNotNull(balance);
        assertEquals(expected, balance);
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void testWithdraw5Pesos() throws InsufficientFundsException {
        //| original_balance | amount  | final_balance       |
        //| 10 pesos         | 5 pesos | 5 pesos             |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal(5), "pesos");
        BankAccount account = new BankAccount(new BigDecimal(10), "pesos");

        BankAccountBalance balance = account.withdraw(new BigDecimal(5));

        assertNotNull(balance);
        assertEquals(expected, balance);
        assertEquals(expected, account.getBalance());
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdraw5PesosWithInsufficientFunds() throws InsufficientFundsException {
        //| original_balance | amount  | final_balance       |
        //| 0 pesos          | 5 pesos | insufficient funds  |

        BankAccount account = new BankAccount(new BigDecimal(0), "pesos");

        account.withdraw(new BigDecimal(5));
    }

    @Test
    public void testGetBalance024Dollars() {
        //| original_balance | final_balance | ratio |
        //| 10 pesos         | 0.24 dollars  | 42.5  |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal("0.24"), "dollars");
        BankAccount account = new BankAccount(new BigDecimal(10), "pesos");
        BigDecimal ratio = new BigDecimal(42.5);

        BankAccountBalance balance = account.getBalance(ratio, "dollars");

        assertNotNull(balance);
        assertEquals(expected, balance);
    }

    @Test
    public void testGetBalance029Dollars() {
        //| 12 pesos         | 0.29 dollars  | 42.5  |

        BankAccountBalance expected = new BankAccountBalance(new BigDecimal("0.29"), "dollars");
        BankAccount account = new BankAccount(new BigDecimal(12), "pesos");
        BigDecimal ratio = new BigDecimal(42.5);

        BankAccountBalance balance = account.getBalance(ratio, "dollars");

        assertNotNull(balance);
        assertEquals(expected, balance);
    }
}