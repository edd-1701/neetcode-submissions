/**
    DP problem,

    recursive solution, start at end and work to origin

*/

class Solution {
    private Integer[][] cache; 

    public int uniquePaths(int m, int n) {
        cache = new Integer[m][n];
        return helper(m - 1, n - 1);
    }

    private int helper(int m, int n) {
        if (cache[m][n] != null) {
            return cache[m][n];
        }

        if (m == 0 && n == 0) {
            return 1;
        } else if (m == 0) {
            return helper(m, n - 1);
        } else if (n == 0) {
            return helper(m - 1, n);
        }

        final var result = helper(m - 1, n) + helper(m, n - 1);
        cache[m][n] = result;
        return result;
    }
}
