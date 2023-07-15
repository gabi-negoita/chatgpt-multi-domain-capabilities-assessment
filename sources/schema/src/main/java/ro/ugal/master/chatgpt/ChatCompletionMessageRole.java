package ro.ugal.master.chatgpt;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChatCompletionMessageRole {

    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");

    @Getter
    @JsonValue
    private final String value;
}
