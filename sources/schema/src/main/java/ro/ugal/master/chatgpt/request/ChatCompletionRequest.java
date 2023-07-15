package ro.ugal.master.chatgpt.request;

import lombok.*;
import ro.ugal.master.chatgpt.ChatCompletionMessage;
import ro.ugal.master.chatgpt.ChatCompletionMessageRole;

import java.util.Collections;
import java.util.List;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionRequest {

    private String model;
    private List<ChatCompletionMessage> messages;

    public static ChatCompletionRequest buildDefaultFrom(String input, String model) {
        return ChatCompletionRequest.builder()
                .model(model)
                .messages(Collections.singletonList(ChatCompletionMessage.builder()
                        .role(ChatCompletionMessageRole.USER)
                        .content(input)
                        .build()))
                .build();
    }
}
