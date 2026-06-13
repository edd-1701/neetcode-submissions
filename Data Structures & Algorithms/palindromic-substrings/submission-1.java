class Solution {
    public int countSubstrings(String s) {
        final var LEN = s.length();
        final var dp = new boolean[LEN][LEN];
        var result = 0;

        for (var i = LEN - 1; i>= 0; i--) {
            for (var j = i; j < LEN; j++) {
                final var sameIndex = i == j;
                final var sameChar = s.charAt(i) == s.charAt(j);
                final var subStrLenIs2 = j - i <= 2;

                if (sameIndex || sameChar  && (subStrLenIs2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    result += 1;
                }
            }
        }
        return result;
    }
}
