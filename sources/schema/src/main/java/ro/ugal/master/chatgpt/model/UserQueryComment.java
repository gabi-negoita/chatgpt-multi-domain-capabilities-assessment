package ro.ugal.master.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserQueryComment {

    DECIMAL_DIGIT_OFF("Decimal digits are off."),
    FINAL_RESULT_DECIMAL_DIGIT_OFF("The final result's decimal digits are off."),
    SIGNIFICANT_DIGIT_OFF("Significant digits are off."),
    INCORRECT_SIGN("The sign is incorrect."),
    FINAL_RESULT_INCORRECT_SIGN("The final result's sign is incorrect."),
    FLOATING_POINT_INCORRECTLY_PLACED("The floating point is incorrectly placed."),
    RESULT_IS_WAY_OFF("The result is way off."),
    NO_ANSWER_GIVEN("No answer given."),
    REVERSED_ORDER("The order is reversed."),
    INCORRECT_ORDER("The order is incorrect."),
    PARTIALLY_INCORRECT_ORDER("The order is partially incorrect."),
    INCORRECT_ANSWER("The answer is incorrect."),
    INCORRECT_ANSWER_DUE_TO_ARITHMETICAL_MISTAKE("The answer is incorrect due to arithmetical mistake."),
    PARTIALLY_INCORRECT_ANSWER("The answer is partially incorrect."),
    JUSTIFIED_INCORRECT_ANSWER("The answer is incorrect, but it was justified."),
    INCOMPLETE_IMPLEMENTATION_PROVIDED("Incomplete implementation provided."),
    INCORRECT_IMPLEMENTATION_PROVIDED("Incorrect implementation provided."),
    NO_IMPLEMENTATION_PROVIDED("No implementation provided."),
    QUERY_IMPOSSIBLE_TO_ANSWER_WITH_PLAUSIBLE_ANSWER("The answer is plausible, but the query cannot be answered."),
    QUERY_IMPOSSIBLE_TO_ANSWER_WITH_NO_PLAUSIBLE_ANSWER("The answer is not plausible and the query cannot be answered.");

    @Getter
    @JsonValue
    private final String value;
}
