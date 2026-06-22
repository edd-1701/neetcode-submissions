class Solution {
    private int m;
    private int n;
    private Map<String, Integer> memo = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        this.m = m;
        this.n = n;

        return helper(m-1, n-1);
    }


    private int helper(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m == 0) {
            return helper(m, n - 1);
        }

        if (n == 0) {
            return helper(m - 1, n);
        }

        final var memoKey = "" + m + "," + n;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        final var result = helper(m-1, n) + helper(m, n-1);
        memo.put(memoKey, result);
        return result;

    }
}
