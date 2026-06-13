class Solution {
    private String s;
    private Set<String> dict;
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];

        return helper(0);        
    }

    private boolean helper(int indexAt) {
        if (indexAt == s.length()) {
            return true;
        } else if (memo[indexAt] != null) {
            return memo[indexAt];
        }

        var result = false;
        for (var i = indexAt; i < s.length(); i++) {

            final var substr = s.substring(indexAt, i+1);

            // System.out.println("left: %s, right: %s, substr: %s".formatted(
            //     indexAt, i, substr
            // ));

            if (!dict.contains(substr)) {
                continue;
            }

            if (helper(i + 1)) {
                result = true;
                break;
                // return true;
            }
        }

        memo[indexAt] = result;
        return result;
    }
}
