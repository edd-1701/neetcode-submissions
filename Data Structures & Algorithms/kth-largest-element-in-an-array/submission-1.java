class Solution {
    public int findKthLargest(int[] nums, int k) {
        final var heap = new PriorityQueue<Integer>();

        for (var num : nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();

    }
}
