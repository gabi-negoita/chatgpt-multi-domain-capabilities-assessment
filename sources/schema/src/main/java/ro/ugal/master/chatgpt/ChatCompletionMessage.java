package ro.ugal.master.chatgpt;

import lombok.*;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionMessage {

    private ChatCompletionMessageRole role;
    private String content;
}
