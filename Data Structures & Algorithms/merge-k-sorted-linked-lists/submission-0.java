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
        final var xfd = new ArrayList<Integer>();
        for (var root : lists) {
            var currentNode = root;
            while (currentNode != null) {
                xfd.add(currentNode.val);
                currentNode = currentNode.next;
            }
        }
        xfd.sort(Integer::compare);

        var resultHead = new ListNode(-1);

        var currentNode = resultHead;
        while (!xfd.isEmpty()) {
            currentNode.next = new ListNode(xfd.removeFirst());
            currentNode = currentNode.next;
        }

        return resultHead.next;
    }
}
