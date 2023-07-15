package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ro.ugal.master.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.ugal.master.util.ListNode.getListNodeFrom;

public class MergeTwoSortedListsTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(
                        getListNodeFrom(new int[]{1, 2, 4}),
                        getListNodeFrom(new int[]{1, 3, 4}),
                        getListNodeFrom(new int[]{1, 1, 2, 3, 4, 4})),
                Arguments.of(
                        getListNodeFrom(new int[0]),
                        getListNodeFrom(new int[0]),
                        new ListNode()),
                Arguments.of(
                        getListNodeFrom(new int[0]),
                        getListNodeFrom(new int[]{0}),
                        new ListNode(0)));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testMergeTwoLists(ListNode input1, ListNode input2, ListNode output) {
        ListNode result = new MergeTwoSortedLists().mergeTwoLists(input1, input2);
        while (result != null && output != null) {
            assertEquals(output.val, result.val);

            result = result.next;
            output = output.next;
        }
    }

}