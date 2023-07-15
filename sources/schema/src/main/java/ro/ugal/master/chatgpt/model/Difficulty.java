package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Difficulty {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    @Getter
    @JsonValue
    private final String value;

}
