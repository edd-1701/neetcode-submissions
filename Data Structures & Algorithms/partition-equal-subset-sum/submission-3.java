class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var num : nums) {
            sum += num;
        }

        if (sum % 2 > 0) {
            return false;
        }

        final var target = sum / 2;

        final var dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        for (var i = 1; i <= nums.length; i++) {
            for (var s = 0; s <= target; s++) {
                dp[i][s] = dp[i-1][s];

                if (s >= nums[i-1]) {
                    dp[i][s] = dp[i][s] || dp[i-1][s - nums[i-1]];
                }
            }
        }

        return dp[nums.length][target];


    }

}
