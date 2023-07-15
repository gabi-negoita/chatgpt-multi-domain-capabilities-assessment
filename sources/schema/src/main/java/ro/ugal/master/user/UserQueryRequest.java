package ro.ugal.master.user;

import lombok.*;
import ro.ugal.master.chatgpt.model.ChatGptModel;
import ro.ugal.master.chatgpt.model.UserQueryConfidence;
import ro.ugal.master.chatgpt.model.UserQueryInputType;
import ro.ugal.master.chatgpt.model.UserQueryReference;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryRequest {

    private String title;
    private String input;
    private UserQueryInputType inputType;
    private String result;
    private UserQueryReference reference;
    private UserQueryConfidence confidence;
    private ChatGptModel model;
}
