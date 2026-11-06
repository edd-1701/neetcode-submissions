class Solution {
    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return helper(0, 0, text1, text2);
    }

    /**
        if either string is exhausted, return 0

        if (memo[i][j] available)
            return memo[i][j]


        if the chars  match (s1[i] == s2[j]):
            return 1 + result of advancing the pointers
        else:
            return 1 + Math.max(helper(i+1, j), helper(i, j+1))

        memo[i][j] = result

    */
    private int helper(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        var result = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = 1+ helper(i + 1, j + 1, s1, s2);
        } else {
            result = Math.max(helper(i, j + 1, s1, s2), helper(i + 1, j, s1, s2));
        }

        memo[i][j] = result;
        return result;
    }
}
