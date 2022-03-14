package singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean(name = "bean1")
    public CustomerAccount customerAccount() {
        return new CustomerAccount("Test User 1");
    }

    @Bean(name = "bean2")
    public CustomerAccount customerAccount1() {
        return new CustomerAccount("Test User 2");
    }
}