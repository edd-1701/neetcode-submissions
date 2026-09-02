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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final var dummyHead = new ListNode();
        var currentNode = dummyHead;

        var p1 = list1;
        var p2 = list2;
        while (p1 != null || p2 != null) {
            final var num1 = p1 == null ? Integer.MAX_VALUE : p1.val;
            final var num2 = p2 == null ? Integer.MAX_VALUE : p2.val;

            if (num1 <= num2) {
                currentNode.next = p1;
                currentNode = p1;
                p1 = p1.next;
            } else {
                currentNode.next = p2;
                currentNode = p2;
                p2 = p2.next;
            }
        }

        return dummyHead.next;
    }
}