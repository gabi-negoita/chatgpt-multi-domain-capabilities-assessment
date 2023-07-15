package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{3, 6, 8, 12, 42}, 24, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testSearchInsert(int[] inputList, int inputTarget, int output) {
        assertEquals(new SearchInsertPosition().searchInsert(inputList, inputTarget), output);
    }

}