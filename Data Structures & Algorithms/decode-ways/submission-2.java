class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int indexAt) {
        if (cache.containsKey(indexAt)) {
            return cache.get(indexAt);
        }

        if (indexAt == s.length()) {
            return 1;
        }

        final var currDigit = s.charAt(indexAt);

        if (currDigit == '0') {
            return 0;
        }


        var result = helper(s, indexAt + 1);

        final var lookAhead = indexAt < s.length() - 1;
        if (lookAhead && (currDigit == '1' || (currDigit == '2' && s.charAt(indexAt + 1) < '7'))) {
            result += helper(s, indexAt + 2);
        }

        cache.put(indexAt, result);
        return result;
    }


}
