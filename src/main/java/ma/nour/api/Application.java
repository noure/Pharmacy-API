package ma.nour.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author noureddine
 *
 */
@ComponentScan("ma.nour.api")
@EnableAutoConfiguration 
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
