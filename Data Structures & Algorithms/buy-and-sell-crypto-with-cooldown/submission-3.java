class Solution {
    private final static int HOLD_IDX = 0;
    private final static int NO_HOLD_IDX = 1;

    private int[] prices;
    private Integer[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][2];

        // return helperRecursive(0, false);
        return helperBottomUp();
    }


    /*
        Bottom up
        2D DP 
            first dimension is the day
            then 2 options for each day, depending on if I'm holding or not
        Recurrence relationship

        Max profit if I hold today, max of two values:
            - in cooldown period, from selling yesterday
            - have no shares, buy one today

        Max profit if I not holding today, max of two values:
            - didn't hold yesterday, and do nothing today
            - selling a share today
    */
    private int helperBottomUp() {
        final var dp = new int[prices.length][2];
        dp[0][HOLD_IDX] = -prices[0];

        for (var day = 1; day < prices.length; day++) {

            final var prevProfit = day > 1 ? dp[day-2][NO_HOLD_IDX] : 0;
            dp[day][HOLD_IDX] = Math.max(
                dp[day-1][HOLD_IDX], //Do nothing, carry over from prev day
                prevProfit - prices[day] //buying again after a cooldown
            );
            dp[day][NO_HOLD_IDX] = Math.max(
                dp[day-1][NO_HOLD_IDX],
                dp[day-1][HOLD_IDX] + prices[day]
            );
        }

        return Math.max(dp[prices.length-1][HOLD_IDX], dp[prices.length-1][NO_HOLD_IDX]);
    }

    /*
        Three Decisions 
        not holding stock, buy today
            -price + helper(day+1, holding=true)
        holding stock, keep holding AKA do nothing
            helper(day+1, holding=true)
        holding stock, sell
            helper(day+2, holding=false)
    */
    private int helperRecursive(int day, boolean holding) {
        if (day >= prices.length) {
            return 0;
        }

        final var memoIndex = holding ? 1 : 0;
        if (memo[day][memoIndex] != null) {
            return memo[day][memoIndex];
        }

        var buyDecision = Integer.MIN_VALUE;
        if (!holding) {
            buyDecision = -prices[day] + helperRecursive(day+1, true);
        }
         
        final var keepHoldDecision = helperRecursive(day+1, holding);

        var sellDecision = Integer.MIN_VALUE;
        if (holding) {
            sellDecision = prices[day] + helperRecursive(day+2, false);
        }

        final var result = Math.max(
            buyDecision,
            Math.max(keepHoldDecision, sellDecision)
        );
        memo[day][memoIndex] = result;
        return result;


    }
}
