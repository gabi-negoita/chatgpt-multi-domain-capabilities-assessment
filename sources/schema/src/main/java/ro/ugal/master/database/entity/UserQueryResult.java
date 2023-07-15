package ro.ugal.master.database.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.ugal.master.chatgpt.model.*;

import javax.print.DocFlavor;
import java.time.LocalDateTime;

@Entity
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryResult {

    @Id
    private String id;
    private String title;
    private String input;
    private String inputType;
    private String result;
    private String output;
    private Integer rating;
    private String comment;
    private String reference;
    private String confidence;
    private LocalDateTime timestamp;
    private String model;
}
