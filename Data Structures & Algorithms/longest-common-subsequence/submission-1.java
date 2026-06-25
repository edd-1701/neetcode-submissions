class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int longestCommonSubsequence(String text1, String text2) {
        return helper(0, 0, text1, text2);
    }

    private int helper(int i, int j, String text1, String text2) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        final var cacheKey = "" + i + "," + j;
        if (memo.containsKey(cacheKey)) {
            return memo.get(cacheKey);
        }


        final var charsMatch = text1.charAt(i) == text2.charAt(j);


        final var result = charsMatch ? (1 + helper(i + 1, j + 1, text1, text2)) :
            Math.max(helper(i + 1, j, text1, text2), helper(i, j + 1, text1, text2));

        memo.put(cacheKey, result);
        return result;
    }
}
