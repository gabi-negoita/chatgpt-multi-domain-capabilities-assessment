package ro.ugal.master.task;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ugal.master.UserQueryResponseToUserQueryResultConverter;
import ro.ugal.master.chatgpt.model.ChatGptModel;
import ro.ugal.master.chatgpt.model.Difficulty;
import ro.ugal.master.chatgpt.model.UserQueryInputType;
import ro.ugal.master.chatgpt.model.UserQueryReference;
import ro.ugal.master.controller.ChatGPTApi;
import ro.ugal.master.converter.DifficultyToUserQueryConfidenceConverter;
import ro.ugal.master.service.UserQueryService;
import ro.ugal.master.user.UserQueryRequest;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;

@Slf4j
@Component
public class LeetcodeCodingProblemsTask {

    private static final String DATASET = "leetcode-coding-problems.json";
    private static final String USE_JAVA_LANGUAGE_TEXT = "Resolve the following coding problem using the Java language.\n";

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();
    private final DifficultyToUserQueryConfidenceConverter confidenceConverter = new DifficultyToUserQueryConfidenceConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, IOException, InterruptedException {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();

        // convert JSON file to map
        JsonNode node = mapper.readTree(new File(Objects.requireNonNull(LeetcodeCodingProblemsTask.class.getClassLoader().getResource(DATASET)).toURI()));

        for (var item : node) {
            var title = item.get("title").asText();
            var difficulty = item.get("difficulty").asText();
            var content = item.get("content").asText();
            var testCases = item.get("testCases").asText();

            // Call the ChatGPT api
            log.info("Asking ChatGPT: " + content + "\nExpected result: " + testCases);
            var request = UserQueryRequest.builder()
                    .title("Coding problem: " + title)
                    .input(USE_JAVA_LANGUAGE_TEXT + content)
                    .inputType(UserQueryInputType.LEETCODE_CODING_PROBLEMS)
                    .result(title + " test cases:\n" + testCases)
                    .reference(UserQueryReference.LEETCODE_CODING_PROBLEMS)
                    .confidence(confidenceConverter.apply(Difficulty.valueOf(difficulty.toUpperCase())))
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
