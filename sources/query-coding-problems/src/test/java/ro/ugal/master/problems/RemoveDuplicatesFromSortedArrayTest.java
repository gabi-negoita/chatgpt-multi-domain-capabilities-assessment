package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
                Arguments.of(new int[]{0, 0, 2, 2, 2, 2, 2, 3, 3, 4, 6, 7, 7}, 6));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testRemoveDuplicates(int[] input, int output) {
        assertEquals(new RemoveDuplicatesFromSortedArray().removeDuplicates(input), output);
    }

}
