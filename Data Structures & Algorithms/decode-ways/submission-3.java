class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();


    public int numDecodings(String s) {
        return helper(s, 0);        
    }

    private int helper(String s, int i) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        if (i == s.length()) {
            return 1;
        }

        final var digit = s.charAt(i);

        if (digit == '0') {
            return 0;
        }

        var result = helper(s, i + 1);

        
        final Integer nextDigit = i < s.length() - 1 ? s.charAt(i+1) - '0' : null;
        final var validTensNum = digit == '1' && nextDigit != null;
        final var validTwentys = digit == '2' && nextDigit != null && nextDigit <= 6;

        if (validTensNum || validTwentys) {
            result += helper(s, i + 2);
        }

        cache.put(i, result);
        return result;
        

    }
}
