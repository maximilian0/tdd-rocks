package acceptance.tdd.rocks.steps;

import acceptance.tdd.rocks.hooks.World;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import tdd.rocks.domain.BankAccount;
import tdd.rocks.domain.BankAccountBalance;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountManagementSteps extends Steps {

    private TestRestTemplate restTemplate;
    private World world = World.UNIQUE_INSTANCE;

    @Autowired
    public BankAccountManagementSteps(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Given("my bank account with number (.*) in (.*)$")
    public void myBankAccountWithNumberAccountNumberInCurrency(String accountNumber, String currency) {

        BankAccount bankAccount = new BankAccount(new BigDecimal(0), currency);
        BankAccount.REPOSITORY.put(accountNumber, bankAccount);
        world.setBankAccount(bankAccount);
    }

    @And("(.*) already deposited$")
    public void originalBalanceAlreadyDeposited(String originalBalance) {

        world.getBankAccount().deposit((BigDecimal) world.stringToAmountOfMoney(originalBalance).get("amount"));
    }

    @When("I ask for the account (.*) balance$")
    public void iAskForTheAccountBalance(String accountNumber) {

        ResponseEntity<BankAccountBalance> responseEntity = restTemplate.getForEntity(
                String.format("/accounts/%s/balance", accountNumber),
                BankAccountBalance.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        world.setAccountBalance(responseEntity.getBody());
    }

    @When("I made a deposit of (.*) into (.*)$")
    public void iMadeADepositOfAmount(String amount, String accountNumber) {

        ResponseEntity<BankAccountBalance> responseEntity = restTemplate.postForEntity(
                String.format("/accounts/%s/deposit", accountNumber),
                world.stringToAmountOfMoney(amount),
                BankAccountBalance.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        world.setAccountBalance(responseEntity.getBody());
    }

    @Then("the balance is (.*)$")
    public void theBalanceIsFinalBalance(String finalBalance) {

        BankAccountBalance expectedBalance = new BankAccountBalance(
                (BigDecimal) world.stringToAmountOfMoney(finalBalance).get("amount"),
                "pesos");
        assertEquals(expectedBalance, world.getBankAccountBalance());
    }
}
