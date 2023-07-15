package ro.ugal.master.problems;

import ro.ugal.master.util.ListNode;

/*
 Resolve the following coding problem using the Java language.
 Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

 You may not alter the values in the list's nodes, only nodes themselves may be changed.



 Example 1:
 Input: head = [1,2,3,4,5], k = 2
 Output: [2,1,4,3,5]

 Example 2:
 Input: head = [1,2,3,4,5], k = 3
 Output: [3,2,1,4,5]


 Constraints:

 The number of nodes in the list is n.
 1 <= k <= n <= 5000
 0 <= Node.val <= 1000


 Follow-up: Can you solve the problem in O(1) extra memory space?
*/

public class ReverseNodesInKGroup {

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nextGroup = tail.next;
            ListNode reversedHead = reverseLinkedList(head);
            prev.next = reversedHead;
            head.next = nextGroup;
            prev = head;
            head = nextGroup;
        }
        return dummy.next;
    }

}
