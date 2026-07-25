class Solution {
    private String s;
    private String p;
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        memo = new Boolean[s.length() + 1][p.length() + 1];

        return helper(0, 0);
    }

    /**

        base case: pattern is exhausted
            return true if string is exhausted


    */
    private boolean helper(int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        final var isMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
        final var zeroOrMore = j < p.length() - 1 && p.charAt(j + 1) == '*';

        var result = false;
        if (zeroOrMore) {
            // if zero or more
            //  explore zero branch helper(i+1, j+2)
            //  explore multiple branch isMatch && helper(i+1, j)
            final var zeroResult = helper(i, j + 2);
            final var multipleResult = isMatch && helper(i + 1, j);
            result = zeroResult || multipleResult;
        } else {
            // if single match
            //  isMatch && helper(i+1, j+1)
            result = isMatch && helper(i + 1, j + 1);
        }

        memo[i][j] = result;
        return result;
    }
}
