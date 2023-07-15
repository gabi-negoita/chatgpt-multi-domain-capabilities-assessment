package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeSubstringTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLongestPalindrome(String input, String output) {
        assertEquals(new LongestPalindromeSubstring().longestPalindrome(input), output);
    }

}