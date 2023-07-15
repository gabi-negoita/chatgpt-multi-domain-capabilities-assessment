package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testFindMedianSortedArrays(int[] input1, int[] input2, double output) {
        assertEquals(new MedianOfTwoSortedArrays().findMedianSortedArrays(input1, input2), output);
    }

}