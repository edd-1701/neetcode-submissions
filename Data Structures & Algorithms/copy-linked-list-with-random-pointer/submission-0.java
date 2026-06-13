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
        if (head == null) {
            return null;
        }

        final var nodeMap = new LinkedHashMap<Node, Node>();

        var currentNode = head;
        while (currentNode != null) {
            nodeMap.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }

        for (var entry : nodeMap.entrySet()) {
            final var originalNode = entry.getKey();
            final var copyNode = entry.getValue();

            copyNode.next = nodeMap.get(originalNode.next);
            copyNode.random = nodeMap.get(originalNode.random);
        }

        return nodeMap.get(head);
    }
}
