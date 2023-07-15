package ro.ugal.master.user;

import lombok.*;
import ro.ugal.master.chatgpt.model.*;

import java.time.LocalDateTime;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryResponse {

    private String id;
    private String title;
    private String input;
    private UserQueryInputType inputType;
    private String result;
    private String output;
    private UserQueryRating rating;
    private String comment;
    private UserQueryReference reference;
    private UserQueryConfidence confidence;
    private LocalDateTime timestamp;
    private ChatGptModel model;
}
