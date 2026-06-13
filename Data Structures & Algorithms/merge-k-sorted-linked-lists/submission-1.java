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
    public ListNode mergeKLists(ListNode[] lists) {

        final var heap = new PriorityQueue<ListNode>(
            (a,b) -> Integer.compare(a.val, b.val)
        );
        for (var root : lists) {
            var currentNode = root;
            while (currentNode != null) {
                heap.add(currentNode);
                currentNode = currentNode.next;
            }
        }


        var resultHead = new ListNode(-1);

        var currentNode = resultHead;
        while (!heap.isEmpty()) {
            final var nextNode = heap.poll();
            nextNode.next = null;

            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return resultHead.next;
    }
}
