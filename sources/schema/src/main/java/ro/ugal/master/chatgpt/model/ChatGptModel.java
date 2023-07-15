package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChatGptModel {

    GPT_4("gpt-4"),
    GPT_3_5_TURBO("gpt-3.5-turbo");

    @Getter
    @JsonValue
    private final String value;
}
