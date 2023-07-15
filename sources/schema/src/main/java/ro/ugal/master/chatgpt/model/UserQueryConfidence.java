package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserQueryConfidence {

    NOT_SET("N/A"),
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    @Getter
    @JsonValue
    private final String value;
}
