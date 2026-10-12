class Solution {
    public int findKthLargest(int[] nums, int k) {
        final var maxHeap = new PriorityQueue<Integer>();

        for (var num : nums) {
            maxHeap.add(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
