package unit.tdd.rocks;

import org.junit.Test;
import tdd.rocks.TddRocksApplication;

import static org.junit.Assert.assertNotNull;

public class TddRocksApplicationTest {

    @Test
    public void testAppHasAGreeting() {
        TddRocksApplication classUnderTest = new TddRocksApplication();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
