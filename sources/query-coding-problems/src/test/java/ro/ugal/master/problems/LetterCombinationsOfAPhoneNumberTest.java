package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsOfAPhoneNumberTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("", Collections.emptyList()),
                Arguments.of("2", List.of("a", "b", "c")));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testLetterCombinations(String input, List<String> output) {
        assertEquals(new LetterCombinationsOfAPhoneNumber().letterCombinations(input), output);
    }

}