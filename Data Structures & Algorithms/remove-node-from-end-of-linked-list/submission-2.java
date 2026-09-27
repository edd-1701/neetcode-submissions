
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }


        final var nodeList = new ArrayList<ListNode>();
        var currNode = head;
        while (currNode != null) {
            nodeList.add(currNode);
            currNode = currNode.next;
        }

        final var idxToRemove = nodeList.size() - n;
        final var nextIdx = idxToRemove + 1;

        if (idxToRemove == 0 && nodeList.size() > 1) {
            return nodeList.get(1);
        } else if (idxToRemove == 0) {
            return null;
        }

        final var prevNode = nodeList.get(idxToRemove - 1);
        prevNode.next = prevNode.next.next;

        return nodeList.getFirst();



    }
}
