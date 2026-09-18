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
        final var resultHead = new ListNode();
        var sumNode = resultHead;

        var p1 = l1;
        var p2 = l2;
        var carryOver = 0;
        while (p1 != null || p2 != null) {
            final var num1 = p1 == null ? 0 : p1.val;
            final var num2 = p2 == null ? 0 : p2.val;

            var sum = num1 + num2 + carryOver;
            carryOver = 0;

            if (sum > 9) {
                carryOver = sum / 10;
                sum %= 10;
            }

            final var newNode = new ListNode(sum);
            sumNode.next = newNode;
            sumNode = newNode;

            p1 = p1 == null ? p1 : p1.next;
            p2 = p2 == null ? p2 : p2.next;
        }

        if (carryOver > 0) {
            sumNode.next = new ListNode(carryOver);
        }

        return resultHead.next;
    }
}
