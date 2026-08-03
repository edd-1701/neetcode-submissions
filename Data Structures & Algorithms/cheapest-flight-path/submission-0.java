class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (var i = 0; i <= k; i++) {
            final var pricesCopy = Arrays.copyOf(prices, n);

            for (var flight : flights) {
                var currSrc = flight[0];
                var currDst = flight[1];
                var price = flight[2];

                if (prices[currSrc] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[currSrc] + price < pricesCopy[currDst]) {
                    pricesCopy[currDst] = prices[currSrc] + price;
                }
            }
            prices = pricesCopy;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
