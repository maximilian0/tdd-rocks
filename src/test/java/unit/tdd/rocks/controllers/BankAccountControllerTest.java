package unit.tdd.rocks.controllers;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tdd.rocks.controllers.BankAccountController;
import tdd.rocks.domain.BankAccountBalance;
import tdd.rocks.services.BankAccountService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountControllerTest {

    @Test
    public void testGetBalance() {

        BankAccountService service = mock(BankAccountService.class);
        when(service.getBalance(anyString())).thenReturn(mock(BankAccountBalance.class));
        BankAccountController controller = new BankAccountController(service);

        ResponseEntity<BankAccountBalance> response = controller.getBalance("1234");

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }
}
