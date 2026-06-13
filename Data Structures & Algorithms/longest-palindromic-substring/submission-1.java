class Solution {

    /*
        build a dp table;

        dp[i][j] -> boolean value

        
    */

    public String longestPalindrome(String s) {

        final var LEN = s.length();

        final var dp = new boolean[LEN][LEN];

        var maxLen = 1;
        var maxPalindromeLeft = 0;
        var maxPalindromeRight = 0;

        for (var i = LEN - 1; i >= 0; i--) {
            for (var j = i; j < LEN; j++) {
                if (i == j || 
                    (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]))) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxPalindromeLeft = i;
                        maxPalindromeRight = j;
                    }
                }
            }
        }

        return s.substring(maxPalindromeLeft, maxPalindromeRight + 1);

    }


}
