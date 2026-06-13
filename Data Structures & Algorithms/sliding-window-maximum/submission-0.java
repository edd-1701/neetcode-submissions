class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final var retVal = new int[nums.length - k + 1];
        var retValIndex = 0;

        final var maxHeap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        for (var i = 0; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});
            if (i < k-1) {
                continue;
            }

            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= (i - k)) {
                maxHeap.poll();
            }
            retVal[retValIndex++] = maxHeap.peek()[0];
        }


        return retVal;
    }
}
