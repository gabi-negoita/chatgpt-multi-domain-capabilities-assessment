package ro.ugal.master.chatgpt.response;

import lombok.*;

import java.util.List;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatCompletionResponse {

    private String id;
    private String object;
    private Long created;
    private String model;
    private CreateCompletionResponseUsage usage;
    private List<CreateChatCompletionResponseChoice> choices;
}
