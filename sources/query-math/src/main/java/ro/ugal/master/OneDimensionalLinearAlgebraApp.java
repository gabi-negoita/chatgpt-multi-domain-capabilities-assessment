package ro.ugal.master;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.algebra.OneDimensionalLinearAlgebraTask;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@SpringBootApplication
public class OneDimensionalLinearAlgebraApp {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, URISyntaxException, JsonProcessingException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(OneDimensionalLinearAlgebraApp.class, args);

        // Start task
        context.getBean(OneDimensionalLinearAlgebraTask.class).start();
    }

}

