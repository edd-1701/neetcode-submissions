class Solution {
    private String s;
    private String t;
    private int result = 0;
    private Integer[][] memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        memo = new Integer[s.length()][t.length()];

        return helper(0, 0);
    }

    private int helper(int sIndex, int tIndex) {
        if (tIndex == t.length()) {
            return 1;
        } else if (sIndex >= s.length()) {
            return 0;
        }

        if (memo[sIndex][tIndex] != null) {
            return memo[sIndex][tIndex];
        }

        var matches = 0;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            matches += helper(sIndex + 1, tIndex + 1);
        }

        matches += helper(sIndex + 1, tIndex);

        memo[sIndex][tIndex] = matches;
        return matches;
    }
}
