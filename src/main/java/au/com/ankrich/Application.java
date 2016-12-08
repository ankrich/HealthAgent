package au.com.ankrich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Ankit.Richharia on 5/12/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main (String [] args){
        SpringApplication.run(Application.class, args);
    }

}
