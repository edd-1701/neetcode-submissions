/**
    Top down recursive with memo
*/
class Solution {
    private final static int MAX_NUM = 100_000;
    private int[] coins;
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new Integer[amount + 1];
        memo[0] = 0;

        final var result = helper(amount);

        return result >= MAX_NUM ? -1 : result;
    }

    private int helper(int amount) {
        if (memo[amount] != null) {
            return memo[amount];
        }

        var minWays = MAX_NUM;
        for (var coin : coins) {
            if (coin <= amount) {
                final var ways = helper(amount - coin);
                minWays = Math.min(minWays, ways);
            }
        }
        minWays += 1;

        memo[amount] = minWays;
        return minWays;
    }
}
