package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLastWordTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLengthOfLastWord(String input, int output) {
        assertEquals(new LengthOfLastWord().lengthOfLastWord(input), output);
    }

}