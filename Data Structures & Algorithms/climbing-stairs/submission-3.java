class Solution {
    private Integer[] memo;

    public int climbStairs(int n) {
        memo = new Integer[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 1 || n == 2) {
            return n;
        } else if (n == 0) {
            return 0;
        }

        final var result = helper(n - 1) + helper(n - 2);
        memo[n] = result;
        return result;
    }
}
