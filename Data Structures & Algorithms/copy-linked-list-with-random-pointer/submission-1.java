/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        final var map = new HashMap<Node, Node>();

        var curr = head;
        while (curr != null) {
            final var copyNode = map.computeIfAbsent(curr, k -> new Node(k.val));

            if (curr.next != null) {
                copyNode.next = map.computeIfAbsent(curr.next, k -> new Node(k.val));
            }

            if (curr.random != null) {
                copyNode.random = map.computeIfAbsent(curr.random, k -> new Node(k.val));
            }
            
            curr = curr.next;
        }

        return map.get(head);
    }
}
