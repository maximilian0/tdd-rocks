package tdd.rocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tdd.rocks.domain.BankAccountBalance;
import tdd.rocks.services.BankAccountService;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BankAccountController {

    private BankAccountService service;

    @Autowired
    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/{accountNumber}/balance")
    public ResponseEntity<BankAccountBalance> getBalance(@PathVariable String accountNumber) {
        return new ResponseEntity<>(service.getBalance(accountNumber), OK);
    }

    @PostMapping(value = "/{accountNumber}/deposit")
    public ResponseEntity<BankAccountBalance> postDeposit(@PathVariable String accountNumber,
                                                          @RequestBody Map<String, Object> body) {
        return new ResponseEntity<>(service.postDeposit(accountNumber, body), OK);
    }
}
