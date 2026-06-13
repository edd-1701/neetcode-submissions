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
        final var resultHead = new ListNode(-1);
        

        var nodeA = list1;
        var nodeB = list2;

        var resultNode = resultHead;
        while (nodeA != null || nodeB != null) {
            // System.out.println("NodeA:" + nodeA);
            if (nodeA != null && (nodeB == null || nodeA.val <= nodeB.val)) {
                resultNode.next = nodeA;
                resultNode = nodeA;
                nodeA = nodeA.next;
            } else {
                resultNode.next = nodeB;
                resultNode = nodeB;
                nodeB = nodeB.next;
            }
        }

        return resultHead.next;
    }
}