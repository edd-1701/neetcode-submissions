class Solution {
    public String longestPalindrome(String s) {
        final var LEN = s.length();

        final var dp = new boolean[LEN][LEN];

        var maxPalindromeLen = 0;
        final var resultIdxs = new int []{-1, -1};


        for (var i = LEN - 1; i >= 0; i--) {
            for (var j = i; j < LEN; j++) {
                //if i == j ||
                // char(i) == charj && len <= 2 || outer borders are palindrome


                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }

                if (j - i <= 2 || dp[i+1][j-1]) {
                    dp[i][j] = true;


                    if (j - i + 1 > maxPalindromeLen) {
                        maxPalindromeLen = j - i + 1;
                        resultIdxs[0] = i;
                        resultIdxs[1] = j;
                    }
                }


                

            }
        }


        return s.substring(resultIdxs[0], resultIdxs[1] + 1);
        
    }
}
