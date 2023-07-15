package ro.ugal.master.lucasmccabe;

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
import ro.ugal.master.lgw863.LGW863LogicalQueryTask;
import ro.ugal.master.service.UserQueryService;
import ro.ugal.master.user.UserQueryRequest;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;

import static ro.ugal.master.StringUtils.sanitizeString;

@Slf4j
@Component
public class LUCASMCCABELogicalQueryTask {

    private static final String DATASET = "lucasmccabe-logiqa.json";

    private final UserQueryResponseToUserQueryResultConverter queryConverter = new UserQueryResponseToUserQueryResultConverter();

    @Autowired
    private ChatGPTApi api;

    @Autowired
    private UserQueryService service;

    public void start() throws URISyntaxException, IOException, InterruptedException {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();

        // convert JSON file to map
        JsonNode node = mapper.readTree(new File(Objects.requireNonNull(LGW863LogicalQueryTask.class.getClassLoader().getResource(DATASET)).toURI()));

        for (var item : node.get("rows")) {
            JsonNode currentItemNode = item.get("row");
            var context = currentItemNode.get("context").asText();
            var question = currentItemNode.get("query").asText();
            var optionA = "A. " + currentItemNode.get("options").get(0).asText();
            var optionB = "B. " + currentItemNode.get("options").get(1).asText();
            var optionC = "C. " + currentItemNode.get("options").get(2).asText();
            var optionD = "D. " + currentItemNode.get("options").get(3).asText();
            var resultIndex = currentItemNode.get("correct_option").asInt();
            var result = currentItemNode.get("options").get(resultIndex).asText();

            var query = context + "\n" + question + "\n" + optionA + "\n" + optionB + "\n" + optionC + "\n" + optionD;

            // Call the ChatGPT api
            log.info("Asking ChatGPT: " + query + "\nExpected result: " + result);
            var request = UserQueryRequest.builder()
                    .title("Logic: Deductive reasoning")
                    .input(query)
                    .inputType(UserQueryInputType.LUCASMCCABE_LOGICAL)
                    .result(sanitizeString(result))
                    .reference(UserQueryReference.LUCASMCCABE_LOGIQA_DATASET)
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
