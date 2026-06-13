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
        if (head == null) {
            return false;
        }

        final var nodeSet = new HashSet<ListNode>();

        var currentNode = head;
        while (currentNode != null) {

            if (nodeSet.contains(currentNode)) {
                return true;
            }

            nodeSet.add(currentNode);
            currentNode = currentNode.next;
        }

        return false;
        
    }
}
