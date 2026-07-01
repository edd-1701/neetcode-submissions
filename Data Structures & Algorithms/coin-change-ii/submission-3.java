class Solution {
    private int[] coins;
    private Map<String, Integer> memo = new HashMap<>();

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.coins = coins;
        return helper(0, amount);
    }

    private int helper(int indexAt, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (indexAt >= coins.length) {
            return 0;
        }

        final var memoKey = "" + indexAt + "," + amount;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        var combinations = 0;
        final var coin = coins[indexAt];
        if (coin <= amount) {
            combinations += helper(indexAt, amount - coin) + helper(indexAt + 1, amount);
        }

        memo.put(memoKey, combinations);
        return combinations;
    }
}
