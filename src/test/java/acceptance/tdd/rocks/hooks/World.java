package acceptance.tdd.rocks.hooks;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import tdd.rocks.domain.BankAccount;
import tdd.rocks.domain.BankAccountBalance;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public enum World {

    UNIQUE_INSTANCE;

    private BankAccount bankAccount;
    private BankAccountBalance bankAccountBalance;

    public BankAccount getBankAccount() {

        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {

        this.bankAccount = bankAccount;
    }

    public void setAccountBalance(BankAccountBalance bankAccountBalance) {

        this.bankAccountBalance = bankAccountBalance;
    }

    public BankAccountBalance getBankAccountBalance() {

        return bankAccountBalance;
    }

    public String castToNull(String string) {

        return (string.isEmpty() || string.equals("null")) ?
                null :
                string;
    }

    public String[] castToNull(String[] string) {

        return (string.length == 1) ?
                null :
                string;
    }

    public Object castToInteger(String string) {

        return (StringUtils.isNumeric(string)) ?
                NumberUtils.toInt(string) :
                string;
    }

    public Map<String, Object> stringToAmountOfMoney(String string) {

        Map<String, Object> amountOfMoney = new LinkedHashMap<>();
        String[] split = string.split(" ");
        amountOfMoney.put("amount", new BigDecimal(split[0]));
        amountOfMoney.put("currency", split[1]);
        return amountOfMoney;
    }
}