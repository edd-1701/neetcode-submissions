class Solution {
    private int target;
    private int nums[];
    private int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        this.nums = nums;

        return helper(0, 0);
    }

    private int helper(int i, int sum) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        return helper(i + 1, sum + nums[i]) + helper(i + 1, sum - nums[i]);
    }
}
