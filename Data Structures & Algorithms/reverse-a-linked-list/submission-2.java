/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return reverseHelper(null, head);
    }

    /*
            head = [0,1,2,3]

            reverse(0): nextNode = reverse(0.next)
            reverse(1): nextNode = reverse(1.next)
    */
    private ListNode reverseHelper(ListNode prev, ListNode node) {
        if (node.next == null) {
            node.next = prev;
            return node;
        }
        final var oldNext = node.next;
        node.next = prev;
        return reverseHelper(node, oldNext);
    }
}
