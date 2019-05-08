package acceptance.tdd.rocks.steps;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tdd.rocks.TddRocksApplication;

@ContextConfiguration
@SpringBootTest(
        classes = TddRocksApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class Steps {

    private static final WireMockServer MOCK_SERVER = new WireMockServer(8081);

    @Before
    public void setUp() {

        if (!MOCK_SERVER.isRunning()) {
            MOCK_SERVER.start();
            WireMock.configureFor("localhost", 8081);
        }
    }

    @After
    public void tearDown() {

        MOCK_SERVER.stop();
    }
}
