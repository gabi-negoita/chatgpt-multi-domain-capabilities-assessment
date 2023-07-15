package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLengthOfLongestSubstring(String input, int output) {
        assertEquals(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input), output);
    }

}