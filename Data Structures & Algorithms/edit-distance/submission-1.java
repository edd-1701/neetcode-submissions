class Solution {
    private String source;
    private String target;
    private Integer[][] memo;

    public int minDistance(String word1, String word2) {
        source = word1;
        target = word2;
        memo = new Integer[word1.length()][word2.length()];

        return helper(0, 0);
    }

    private int helper(int sourceIdx, int targetIdx) {
        if (sourceIdx == source.length()) {
            return target.length() - targetIdx;
        }

        if (targetIdx == target.length()) {
            return source.length() - sourceIdx;
        }

        if (memo[sourceIdx][targetIdx] != null) {
            return memo[sourceIdx][targetIdx];
        }

        final var sourceChar = source.charAt(sourceIdx);
        final var targetChar = target.charAt(targetIdx);
        final var charsMatch = sourceChar == targetChar;

        // char already matches
        Integer result;
        if (charsMatch) {
            result = helper(sourceIdx + 1, targetIdx + 1);
        } else {
            // insert a char, only if they don't match
            var insertResult = 1 + helper(sourceIdx, targetIdx + 1);
            // delete a char
            var deleteResult = 1 + helper(sourceIdx + 1, targetIdx);
            // replace a char
            var replaceResult = 1 + helper(sourceIdx + 1, targetIdx + 1);
            result =  Math.min(insertResult, Math.min(deleteResult, replaceResult));
        }

        memo[sourceIdx][targetIdx] = result;
        return result;
    }
}
