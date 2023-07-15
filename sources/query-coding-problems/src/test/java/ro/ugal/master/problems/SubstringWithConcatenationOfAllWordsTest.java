package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstringWithConcatenationOfAllWordsTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, List.of(0, 9)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, Collections.emptyList()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, List.of(6, 9, 12)));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testFindSubstring(String inputString, String[] inputWords, List<Integer> output) {
        assertEquals(new SubstringWithConcatenationOfAllWords().findSubstring(inputString, inputWords), output);
    }
}