package ro.ugal.master.task;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;

@Slf4j
@Component
public class LogicalCodeDebuggingTask {

    private static final String DATASET = "logical-code-debugging-dataset.json";

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, IOException, InterruptedException {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();

        // convert JSON file to map
        JsonNode node = mapper.readTree(new File(Objects.requireNonNull(LogicalCodeDebuggingTask.class.getClassLoader().getResource(DATASET)).toURI()));

        for (var item : node) {
            var title = item.get("title").asText();
            var bugType = item.get("bugType").asText();
            var content = item.get("content").asText();
            var result = item.get("result").asText();

            // Call the ChatGPT api
            log.info("Asking ChatGPT: " + content + "\nExpected result: " + result);
            var request = UserQueryRequest.builder()
                    .title("Debugging problem: " + title)
                    .input(content)
                    .inputType(UserQueryInputType.LOGICAL_DEBUGGING_PROBLEMS)
                    .result("Bug type: " + bugType + ". " + result)
                    .reference(UserQueryReference.JAVA_REVISITED_CODING_PROBLEMS)
                    .confidence(UserQueryConfidence.HIGH)
                    .model(ChatGptModel.GPT_3_5_TURBO)
                    .build();
            var userQueryResponse = api.askChatGPT(request);

            // Save result in the database
            log.info("Saving result to database: " + userQueryResponse.getOutput());
            service.save(queryConverter.apply(userQueryResponse));

            Thread.sleep(Duration.ofSeconds(30).toMillis());
        }
    }

}
