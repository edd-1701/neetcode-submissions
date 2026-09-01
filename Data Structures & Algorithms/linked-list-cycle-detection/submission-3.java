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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        var slowPtr = head;
        var fastPtr = head.next;

        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr.equals(fastPtr)) {
                return true;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return false;
    }
}
