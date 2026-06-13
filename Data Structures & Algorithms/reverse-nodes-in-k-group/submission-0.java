class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        var dummyHead = new ListNode(-1);
        var prev = dummyHead;
        var left = head;
        var right = head;
        var i = 1;
        while (right != null) {
            if (i < k) {
                right = right.next;
                i += 1;
                continue;
            }

            reverse(left, prev, right);
            prev = left;
            left = left.next;
            right = left;
            i = 1;
        }

        return dummyHead.next;
    }

    private static void reverse(ListNode start, ListNode prev, ListNode end) {
        final var stopNode = end.next;
        var currNode = start;
        var prevNode = prev;

        while (currNode != null && currNode != stopNode) {
            final var tmpNext = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tmpNext;
        }
        prev.next = end;
        start.next = stopNode;
    }
}
