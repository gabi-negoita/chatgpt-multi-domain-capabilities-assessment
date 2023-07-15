package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(-654876, -678456),
                Arguments.of(0, 0),
                Arguments.of(120, 21)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testReverse(int input, int output) {
        assertEquals(new ReverseInteger().reverse(input), output);
    }
}