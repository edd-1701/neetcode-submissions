class Solution {
    private int[] nums;
    private int target;
    private Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return helper(0, 0);
    }

    private int helper(int i, int sum) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        final var memoKey = i + "," + sum;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        final var result = helper(i + 1, sum + nums[i]) + helper(i + 1, sum - nums[i]);
        memo.put(memoKey, result);
        return result;
    }
}
