package ro.ugal.master.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ro.ugal.master.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeKSortedListsTest {

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new ListNode[]{
                                ListNode.getListNodeFrom(new int[]{1, 4, 5}),
                                ListNode.getListNodeFrom(new int[]{1, 3, 4}),
                                ListNode.getListNodeFrom(new int[]{2, 6})},
                        ListNode.getListNodeFrom(new int[]{1, 1, 2, 3, 4, 4, 5, 6})),
                Arguments.of(new ListNode(), new ListNode()),
                Arguments.of(new ListNode[]{new ListNode()}, new ListNode()));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testMergeKLists(ListNode[] input, ListNode output) {
        ListNode result = new MergeKSortedLists().mergeKLists(input);
        while (result != null && output != null) {
            assertEquals(output.val, result.val);

            result = result.next;
            output = output.next;
        }
    }
}