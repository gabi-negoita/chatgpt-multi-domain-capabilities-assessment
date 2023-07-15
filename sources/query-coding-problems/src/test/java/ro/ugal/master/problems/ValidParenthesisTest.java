package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesisTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testIsValid(String input, boolean output) {
        assertEquals(new ValidParenthesis().isValid(input), output);
    }

}