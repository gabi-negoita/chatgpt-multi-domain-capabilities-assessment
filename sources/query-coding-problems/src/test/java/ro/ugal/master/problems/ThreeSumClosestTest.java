package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumClosestTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 1, -4}, 1, 2),
                Arguments.of(new int[]{0, 0, 0}, 1, 0));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testThreeSumClosest(int[] inputList, int inputTarget, int output) {
        assertEquals(new ThreeSumClosest().threeSumClosest(inputList, inputTarget), output);
    }

}