package ro.ugal.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.task.SyntaxCodeDebuggingTask;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class SyntaxCodeDebuggingApp {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(SyntaxCodeDebuggingApp.class, args);

        // Start task
        context.getBean(SyntaxCodeDebuggingTask.class).start();
    }

}
