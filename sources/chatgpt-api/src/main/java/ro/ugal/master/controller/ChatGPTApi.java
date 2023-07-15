package ro.ugal.master.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ro.ugal.master.chatgpt.request.ChatCompletionRequest;
import ro.ugal.master.chatgpt.response.CreateChatCompletionResponse;
import ro.ugal.master.user.UserQueryRequest;
import ro.ugal.master.user.UserQueryResponse;

import java.time.LocalDateTime;
import java.util.Objects;

import static ro.ugal.master.chatgpt.model.UserQueryRating.NOT_RATED;

@RestController
public class ChatGPTApi {

    @Value("${chatgpt.url}")
    private String apiUrl;

    @Value("${chatgpt.bearer}")
    private String authBearer;

    @PostMapping("/ask")
    public UserQueryResponse askChatGPT(@Validated
                                        @RequestBody
                                        UserQueryRequest request) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authBearer);

        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionRequest body = ChatCompletionRequest.buildDefaultFrom(request.getInput(), request.getModel().getValue());
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(body), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CreateChatCompletionResponse> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, CreateChatCompletionResponse.class);

        return UserQueryResponse.builder()
                .id(Objects.requireNonNull(response.getBody()).getId())
                .title(request.getTitle())
                .input(request.getInput())
                .inputType(request.getInputType())
                .result(request.getResult())
                .output(response.getBody().getChoices().get(0).getMessage().getContent())
                .rating(NOT_RATED)
                .comment(null)
                .reference(request.getReference())
                .confidence(request.getConfidence())
                .timestamp(LocalDateTime.now())
                .model(request.getModel())
                .build();
    }

}
