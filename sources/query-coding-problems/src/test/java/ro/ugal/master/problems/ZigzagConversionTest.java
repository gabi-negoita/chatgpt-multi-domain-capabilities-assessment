package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigzagConversionTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testConvert(String inputString, int inputNumOfRows, String output) {
        assertEquals(new ZigzagConversion().convert(inputString, inputNumOfRows), output);
    }

}