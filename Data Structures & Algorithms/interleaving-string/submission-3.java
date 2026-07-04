class Solution {
    private String s1;
    private String s2;
    private String s3;
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return helper(0, 0, 0);
    }

    private boolean helper(int i1, int i2, int i3) {
        if (memo[i1][i2] != null) {
            return memo[i1][i2];
        }

        if (i3 == s3.length()) {
            return i1 == s1.length() && i2 == s2.length();
        }

        final var charToMatch = s3.charAt(i3);

        var result = false;
        final var s1InBounds = i1 < s1.length();
        if (s1InBounds && s1.charAt(i1) == charToMatch && helper(i1 + 1, i2, i3 + 1)) {
            result = true;
        }

        final var s2InBounds = i2 < s2.length();
        if (!result && s2InBounds && s2.charAt(i2) == charToMatch && helper(i1, i2 + 1, i3 + 1)) {
            result = true;
        }

        memo[i1][i2] = result;
        return result;
    }
}
