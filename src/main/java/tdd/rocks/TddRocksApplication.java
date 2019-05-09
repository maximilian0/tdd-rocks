package tdd.rocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TddRocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddRocksApplication.class, args);
    }

    public String getGreeting() {
        return "Hello world.";
    }
}
