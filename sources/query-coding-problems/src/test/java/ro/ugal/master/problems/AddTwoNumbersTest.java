package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ro.ugal.master.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.ugal.master.util.ListNode.getListNodeFrom;

public class AddTwoNumbersTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(
                        getListNodeFrom(new int[]{2, 4, 3}),
                        getListNodeFrom(new int[]{5, 6, 4}),
                        getListNodeFrom(new int[]{7, 0, 8})),
                Arguments.of(
                        new ListNode(0),
                        new ListNode(0),
                        new ListNode(0)),
                Arguments.of(
                        getListNodeFrom(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        getListNodeFrom(new int[]{9, 9, 9, 9}),
                        getListNodeFrom(new int[]{8, 9, 9, 9, 0, 0, 0, 1})));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testAddTwoNumbers(ListNode input1, ListNode input2, ListNode output) {
        ListNode result = new AddTwoNumbers().addTwoNumbers(input1, input2);

        while (result != null && output != null) {
            assertEquals(output.val, result.val);

            result = result.next;
            output = output.next;
        }
    }

}
