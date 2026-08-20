class Solution {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var maxProfit = 0;

        for (var i = 1; i < prices.length; i++) {
            lowestPrice = Math.min(lowestPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
        }

        return maxProfit;
    }
}
