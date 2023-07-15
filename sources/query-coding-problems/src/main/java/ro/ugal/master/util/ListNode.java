package ro.ugal.master.util;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
    }

    public static ListNode getListNodeFrom(int[] input) {
        if (input.length == 0) {
            return new ListNode();
        }

        ListNode head = new ListNode(input[0]);
        ListNode node = head;
        for (int j : input) {
            node.next = new ListNode(j);
            node = node.next;
        }

        return head;
    }

}