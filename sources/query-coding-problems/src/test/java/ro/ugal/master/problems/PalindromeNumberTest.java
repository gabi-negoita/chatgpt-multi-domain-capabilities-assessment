package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeNumberTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(0, true),
                Arguments.of(5, true),
                Arguments.of(1223221, true),
                Arguments.of(123123123, false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testIsPalindrome(int input, boolean output) {
        assertEquals(new PalindromeNumber().isPalindrome(input), output);
    }

}