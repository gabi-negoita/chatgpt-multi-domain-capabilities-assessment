package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ro.ugal.master.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseNodesInKGroupTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(ListNode.getListNodeFrom(new int[]{1, 2, 3, 4, 5}), 2, ListNode.getListNodeFrom(new int[]{2, 1, 4, 3, 5})),
                Arguments.of(ListNode.getListNodeFrom(new int[]{1, 2, 3, 4, 5}), 3, ListNode.getListNodeFrom(new int[]{3, 2, 1, 4, 5})));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testReverseKGroup(ListNode inputNode, int inputK, ListNode output) {
        ListNode result = new ReverseNodesInKGroup().reverseKGroup(inputNode, inputK);
        while (result != null && output != null) {
            System.out.println(output.val + "---" + result.val);
            assertEquals(output.val, result.val);

            result = result.next;
            output = output.next;
        }
    }

}