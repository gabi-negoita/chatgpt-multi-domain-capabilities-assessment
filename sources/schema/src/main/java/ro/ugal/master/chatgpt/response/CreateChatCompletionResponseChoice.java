package ro.ugal.master.chatgpt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ro.ugal.master.chatgpt.ChatCompletionMessage;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatCompletionResponseChoice {

    private Integer number;
    private ChatCompletionMessage message;
    @JsonProperty("finish_reason")
    private String finishReason;
    private Integer index;
}
