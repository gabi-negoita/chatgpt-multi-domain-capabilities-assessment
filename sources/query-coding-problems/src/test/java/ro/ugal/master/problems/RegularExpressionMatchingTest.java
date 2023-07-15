package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularExpressionMatchingTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("aa", "a", false),
                Arguments.of("aa", "a*", true),
                Arguments.of("ab", ".*", true));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testIsMatch(String inputString, String inputPattern, boolean output) {
        assertEquals(new RegularExpressionMatching().isMatch(inputString, inputPattern), output);
    }

}