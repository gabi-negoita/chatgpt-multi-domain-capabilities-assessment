package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserQueryRating {

    NOT_RATED(-1),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    @Getter
    @JsonValue
    private final Integer value;
}
