package ro.ugal.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.task.DataExtractionTask;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class DataExtractionApp {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(DataExtractionApp.class, args);

        // Start task
        context.getBean(DataExtractionTask.class).start();
    }

}