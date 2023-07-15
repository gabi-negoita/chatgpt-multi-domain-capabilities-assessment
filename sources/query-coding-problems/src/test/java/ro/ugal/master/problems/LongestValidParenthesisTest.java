package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParenthesisTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("(()", 2),
                Arguments.of(")()())", 4),
                Arguments.of("", 0)
        );
    }

    public void testLongestValidParentheses() {
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLongestValidParentheses(String input, int output) {
        assertEquals(new LongestValidParenthesis().longestValidParentheses(input), output);
    }

}