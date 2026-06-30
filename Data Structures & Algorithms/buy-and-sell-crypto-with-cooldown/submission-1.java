class Solution {
    private int[] prices;
    private Integer[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][2];

        return helper(0, false);
    }

    /*
        Consider all the posibilities

        not holding stock, buy today
            -price + helper(day+1, holding=true)
        holding stock, keep holding
            helper(day+1, holding=true)
        holding stock, sell
            helper(day+2, holding=false)

    */
    private int helper(int day, boolean holding) {
        if (day >= prices.length) {
            return 0;
        }

        final var memoIndex = holding ? 1 : 0;
        if (memo[day][memoIndex] != null) {
            return memo[day][memoIndex];
        }

        var buyDecision = Integer.MIN_VALUE;
        if (!holding) {
            buyDecision = -prices[day] + helper(day+1, true);
        }
         
        final var keepHoldDecision = helper(day+1, holding);

        var sellDecision = Integer.MIN_VALUE;
        if (holding) {
            sellDecision = prices[day] + helper(day+2, false);
        }

        final var result = Math.max(
            buyDecision,
            Math.max(keepHoldDecision, sellDecision)
        );
        memo[day][memoIndex] = result;
        return result;


    }
}
