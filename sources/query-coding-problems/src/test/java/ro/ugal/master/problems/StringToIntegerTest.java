package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testMyAtoi(String input, int output) {
        assertEquals(new StringToInteger().myAtoi(input), output);
    }

}