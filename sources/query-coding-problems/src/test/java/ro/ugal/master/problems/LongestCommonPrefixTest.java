package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"dragon", "dracula", "dragrace"}, "dra")
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLongestCommonPrefix(String[] input, String output) {
        assertEquals(new LongestCommonPrefix().longestCommonPrefix(input), output);
    }

}