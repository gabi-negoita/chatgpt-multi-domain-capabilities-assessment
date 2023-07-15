package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
                Arguments.of(new int[]{0, 1, 1}, Collections.emptyList()),
                Arguments.of(new int[]{0, 0, 0}, List.of(List.of(0, 0, 0)))
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testThreeSum(int[] input, List<List<Integer>> output) {
        assertEquals(new ThreeSum().threeSum(input), output);
    }

}