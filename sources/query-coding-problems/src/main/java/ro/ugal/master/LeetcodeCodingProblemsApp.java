package ro.ugal.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.task.LeetcodeCodingProblemsTask;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class LeetcodeCodingProblemsApp {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(LeetcodeCodingProblemsApp.class, args);

        // Start task
        context.getBean(LeetcodeCodingProblemsTask.class).start();
    }

}
