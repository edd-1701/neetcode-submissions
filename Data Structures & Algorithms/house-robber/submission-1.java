class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] nums, int indexAt) {
        if (indexAt >= nums.length) {
            return 0;
        }

        if (cache.containsKey(indexAt)) {
            return cache.get(indexAt);
        }

        final var robCurrent = nums[indexAt] + helper(nums, indexAt + 2);
        final var robNext = helper(nums, indexAt + 1);

        final var result =  Math.max(
            robCurrent, robNext
        );
        cache.put(indexAt, result);
        return result;
    }
}
