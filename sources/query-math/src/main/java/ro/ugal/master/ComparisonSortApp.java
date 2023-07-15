package ro.ugal.master;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.comparison.ComparisonSortTask;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@SpringBootApplication
public class ComparisonSortApp {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, URISyntaxException, JsonProcessingException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(ComparisonSortApp.class, args);

        // Start task
        context.getBean(ComparisonSortTask.class).start();
    }

}

