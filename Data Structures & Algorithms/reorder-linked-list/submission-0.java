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
    public void reorderList(ListNode head) {
        final var list = new ArrayList<ListNode>();

        var currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }

        var left = 0;
        var right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left += 1;

            if (left == right) {
                break;
            }

            list.get(right).next = list.get(left);
            right -= 1;
        }

        list.get(left).next = null;
    }
}
