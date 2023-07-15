package ro.ugal.master.task;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Chars;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Component
public class DataExtractionTask {

    private static final String DATASET = "data-extraction-dataset.json";
    private static final char TITLE_SEPARATOR = '_';

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, IOException, InterruptedException {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();

        // convert JSON file to map
        JsonNode node = mapper.readTree(new File(Objects.requireNonNull(DataExtractionTask.class.getClassLoader().getResource(DATASET)).toURI()));

        for (var item : node.get("data")) {
            // Get title
            String title = item.get("title").asText().replace(TITLE_SEPARATOR, Chars.SPACE);

            int paragraphLimit = 5;
            for (var paragraphItem : item.get("paragraphs")) {
                if (paragraphLimit == 0) break;

                // Get context
                String context = paragraphItem.get("context").asText();

                int qasLimit = 3;
                for (var qasItem : paragraphItem.get("qas")) {
                    if (qasLimit == 0) break;

                    String question = qasItem.get("question").asText();

                    boolean isImpossibleToAnswer = qasItem.get("is_impossible").asBoolean();
                    Iterator<JsonNode> answerElements = qasItem.get(isImpossibleToAnswer ? "plausible_answers" : "answers").elements();
                    Set<String> answers = new HashSet<>();
                    while (answerElements.hasNext()) {
                        answers.add(answerElements.next().get("text").asText());
                    }

                    var input = "Consider the following paragraph about \"" + title + "\":\n" + context + "\n" + question;
                    var result = (isImpossibleToAnswer ? "Impossible to answer. Plausible results: " : "Results: ") + answers;

                    // Call the ChatGPT api
                    log.info("Asking ChatGPT: " + input + "\nExpected result: " + result);
                    var request = UserQueryRequest.builder()
                            .title("Data extraction: " + title)
                            .input(input)
                            .inputType(UserQueryInputType.DATA_EXTRACTION)
                            .result(result)
                            .reference(UserQueryReference.SQUAD_EXPLORER_DATA_EXTRACTION)
                            .confidence(UserQueryConfidence.HIGH)
                            .model(ChatGptModel.GPT_3_5_TURBO)
                            .build();
                    var userQueryResponse = api.askChatGPT(request);

                    // Save result in the database
                    log.info("Saving result to database: " + userQueryResponse.getOutput());
                    service.save(queryConverter.apply(userQueryResponse));

                    Thread.sleep(Duration.ofSeconds(30).toMillis());

                    // Decrement the limit after successful processing
                    qasLimit--;
                }

                // Decrement limit after successful processing
                paragraphLimit--;
            }
        }
    }

}
