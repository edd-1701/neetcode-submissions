/**

    Create a minHeap[ListNode], with custom comparator that sorts based on value
    It will contain pointers to all the lists

    resultHead = new ListNode()
    currNode = resultHead

    while minHeap is not empty:
        nextNode = pop()
        currNode.next = nextNode
        nextNode = currNode

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        //O(k) space
        final var minHeap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        // O(k * nlogk) time to iterate each list and insert into the heap
        for (var list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        final var resultHead = new ListNode(-1);
        var currNode = resultHead;

        // O(n*k) time to exhaust every node
        while (!minHeap.isEmpty()) {
            final var nextNode = minHeap.poll();

            currNode.next = nextNode;
            currNode = nextNode;

            if (nextNode.next != null) {
                minHeap.add(nextNode.next);
            }
        }

        return resultHead.next;
    }
}
