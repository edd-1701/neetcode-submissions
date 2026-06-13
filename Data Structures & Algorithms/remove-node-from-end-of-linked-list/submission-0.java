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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var list = new ArrayList<ListNode>();

        var currNode = head;
        while (currNode != null) {
            list.add(currNode);
            
            currNode = currNode.next;
        }

        final var targetNodeIdx = list.size() - n;

        if (targetNodeIdx == 0) {
            return list.size() == 1 ? null : head.next;
        } else if (targetNodeIdx == list.size() - 1) {
            list.get(targetNodeIdx-1).next = null;
            return head;
        } else {
            list.get(targetNodeIdx-1).next = list.get(targetNodeIdx).next;
            return head;
        }


    }
}
