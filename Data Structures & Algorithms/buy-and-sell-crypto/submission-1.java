class Solution {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var maxProfit = 0;

        for (var i = 1; i < prices.length; i++) {
            
            final var currPrice = prices[i];
            final var currentProfit = prices[i] - lowestPrice;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }


            if (currPrice < lowestPrice) {
                lowestPrice = currPrice;
            }
        }

        return maxProfit;
    }
}
