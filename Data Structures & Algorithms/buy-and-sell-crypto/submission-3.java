class Solution {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var maxProfit = 0;

        for (var i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            final var currProfit = prices[i] - lowestPrice;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }

        return maxProfit;
    }
}
