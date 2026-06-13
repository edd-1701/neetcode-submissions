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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var head = new ListNode(-1);

        var p1 = l1;
        var p2 = l2;
        var sumNode = head;
        var carryTheOne = false;

        while (p1 != null || p2 != null) {
            final var num1 = p1 == null ? 0 : p1.val;
            final var num2 = p2 == null ? 0 : p2.val;

            var currSum = num1 + num2 + (carryTheOne ? 1 : 0);
            carryTheOne = currSum > 9 ? true : false;
            currSum -= carryTheOne ? 10 : 0;

            sumNode.next = new ListNode(currSum);

            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            sumNode = sumNode.next;
        }

        if (carryTheOne) {
            sumNode.next = new ListNode(1);
        }

        return head.next;
    }
}
