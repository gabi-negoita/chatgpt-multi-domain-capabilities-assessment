package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuSolverTest {

    private static Stream<Arguments> dataSource() {
        char[][] input = new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };

        char[][] output = new char[][]{
                "534678912".toCharArray(),
                "672195348".toCharArray(),
                "198342567".toCharArray(),
                "859761423".toCharArray(),
                "426853791".toCharArray(),
                "713924856".toCharArray(),
                "961537284".toCharArray(),
                "287419635".toCharArray(),
                "345286179".toCharArray()
        };

        return Stream.of(
                Arguments.of(input, 0, 0, output)
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testSolve(char[][] inputBoard, int inputRow, int inputCol, boolean output) {
        assertEquals(new SudokuSolver().solve(inputBoard, inputRow, inputCol), output);
    }

}