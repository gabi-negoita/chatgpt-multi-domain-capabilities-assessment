package ro.ugal.master.arithmetic;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ugal.master.UserQueryResponseToUserQueryResultConverter;
import ro.ugal.master.chatgpt.model.ChatGptModel;
import ro.ugal.master.chatgpt.model.UserQueryConfidence;
import ro.ugal.master.chatgpt.model.UserQueryInputType;
import ro.ugal.master.chatgpt.model.UserQueryReference;
import ro.ugal.master.controller.ChatGPTApi;
import ro.ugal.master.service.UserQueryService;
import ro.ugal.master.user.UserQueryRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;

import static ro.ugal.master.StringUtils.sanitizeString;

@Slf4j
@Component
public class ArithmeticDivisionTask {

    private static final String DATASET = "arithmetic__div.txt";

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, FileNotFoundException, InterruptedException, JsonProcessingException {
        var scanner = new Scanner(new File(Objects.requireNonNull(ArithmeticDivisionTask.class.getClassLoader().getResource(DATASET)).toURI()));

        while (scanner.hasNextLine()) {
            var query = scanner.nextLine();
            var result = scanner.hasNextLine() ? scanner.nextLine() : null;

            if (result == null) break;

            // Call the ChatGPT api
            log.info("Asking ChatGPT: " + query + "\nExpected result: " + result);
            var request = UserQueryRequest.builder()
                    .title("Mathematics: Division")
                    .input(sanitizeString(query))
                    .inputType(UserQueryInputType.MATH_ARITHMETIC_DIVISION)
                    .result(sanitizeString(result))
                    .reference(UserQueryReference.MATHEMATICS_DATASET)
                    .confidence(UserQueryConfidence.HIGH)
                    .model(ChatGptModel.GPT_3_5_TURBO)
                    .build();
            var userQueryResponse = api.askChatGPT(request);

            // Save result in the database
            log.info("Saving result to database: " + userQueryResponse.getOutput());
            service.save(queryConverter.apply(userQueryResponse));

            Thread.sleep(Duration.ofSeconds(20).toMillis());
        }
    }
}
