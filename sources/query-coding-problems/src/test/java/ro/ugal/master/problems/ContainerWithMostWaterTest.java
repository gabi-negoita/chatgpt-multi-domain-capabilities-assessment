package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testMaxArea(int[] input, int output) {
        assertEquals(new ContainerWithMostWater().maxArea(input), output);
    }
}