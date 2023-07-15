package ro.ugal.master.lgw863;

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
public class LGW863LogicalQueryTask {

    private static final String DATASET = "lgw863-logiqa.txt";

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, FileNotFoundException, InterruptedException, JsonProcessingException {
        var scanner = new Scanner(new File(Objects.requireNonNull(LGW863LogicalQueryTask.class.getClassLoader().getResource(DATASET)).toURI()));

        while (scanner.hasNextLine() && scanner.nextLine().isBlank()) {
            var result = scanner.nextLine();
            var context = scanner.nextLine();
            var question = scanner.nextLine();
            var optionA = scanner.nextLine();
            var optionB = scanner.nextLine();
            var optionC = scanner.nextLine();
            var optionD = scanner.nextLine();

            if (result == null) break;

            var query = context + question + "\n" + optionA + "\n" + optionB + "\n" + optionC + "\n" + optionD;

            // Call the ChatGPT api
            log.info("Asking ChatGPT: " + query + "\nExpected result: " + result);
            var request = UserQueryRequest.builder()
                    .title("Logic: Deductive reasoning")
                    .input(query)
                    .inputType(UserQueryInputType.LGW863_LOGICAL)
                    .result(sanitizeString(result.toUpperCase()))
                    .reference(UserQueryReference.LGW863_LOGIQA_DATASET)
                    .confidence(UserQueryConfidence.MEDIUM)
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
