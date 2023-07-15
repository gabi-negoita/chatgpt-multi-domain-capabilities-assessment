package ro.ugal.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.ugal.master.task.LogicalCodeDebuggingTask;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class LogicalCodeDebuggingApp {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        // Start Spring Boot context
        ConfigurableApplicationContext context = SpringApplication.run(LogicalCodeDebuggingApp.class, args);

        // Start task
        context.getBean(LogicalCodeDebuggingTask.class).start();
    }

}
