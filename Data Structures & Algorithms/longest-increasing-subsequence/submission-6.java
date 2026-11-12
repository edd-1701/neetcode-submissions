class Solution {
    private Map<String, Integer> cache = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        
        return helper(0, -1, nums);
    }

    private int helper(int index, int parentIndex, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        final var cacheKey = "" + index + "," + parentIndex;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        var maxFromPrev = -1;
        if (parentIndex == -1 || nums[index] > nums[parentIndex]) {
            maxFromPrev = 1 + helper(index + 1, index, nums);
        }

        var maxFromSkip = helper(index + 1, parentIndex, nums);

        var result = Math.max(maxFromPrev, maxFromSkip);
        cache.put(cacheKey, result);
        return result;

    }
}
