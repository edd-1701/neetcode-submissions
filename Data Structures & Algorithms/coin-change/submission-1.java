class Solution {
    public int coinChange(int[] coins, int amount) {
        final var dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (var i = 1; i < dp.length; i++) {
            for (final var coin : coins) {
                final var lookBackIndex = i - coin;
                if (lookBackIndex >= 0 && (dp[i - coin] + 1) < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        final var result = dp[dp.length - 1];
        return result == (amount + 1) ? -1 : result;
    }
}
