package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardMatchingTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("aa", "a", false),
                Arguments.of("aa", "*", true),
                Arguments.of("cb", "?a", false));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testIsMatch(String inputString, String inputPattern, boolean output) {
        assertEquals(new WildcardMatching().isMatch(inputString, inputPattern), output);
    }

}