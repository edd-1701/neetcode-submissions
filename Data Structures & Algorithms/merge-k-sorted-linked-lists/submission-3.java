class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        var resultHead = new ListNode(-1);
        var resultCurr = resultHead;

        final var pointers = new ListNode[lists.length];
        for (var i = 0; i < lists.length; i++) {
            pointers[i] = lists[i];
        }

        final var heap = new PriorityQueue<ListNode>((a,b) -> Integer.compare(a.val, b.val));
        var completedLists = 0;
        while (completedLists < lists.length) {
            for (var i = 0; i < pointers.length; i++) {
                final var currNode = pointers[i];
                if (currNode == null) {
                    continue;
                }
                heap.add(currNode);
                pointers[i] = currNode.next;
                if (pointers[i] == null) {
                    completedLists += 1;
                }
            }

            final var poppedNode = heap.poll();
            resultCurr.next = poppedNode;
            resultCurr = poppedNode;
        }

        while (!heap.isEmpty()) {
            final var poppedNode = heap.poll();
            resultCurr.next = poppedNode;
            resultCurr = poppedNode;
        }

        resultCurr.next = null;

        return resultHead.next;
    }

    private static boolean allNodesVisited(final ListNode[] pointers) {
        for (var p : pointers) {
            if (p != null) {
                return false;
            }
        }
        return true;
    }
}
