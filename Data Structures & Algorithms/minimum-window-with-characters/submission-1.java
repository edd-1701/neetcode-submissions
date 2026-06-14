class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        final var charMap = new HashMap<Character, Integer>();
        for (var i = 0; i < t.length(); i++) {
            charMap.merge(t.charAt(i), 1, Integer::sum);
        }

        var minLen = Integer.MAX_VALUE;
        var resultIndexes = new int[]{-1, -1};

        var left = 0;
        var right = left;
        while (right < s.length()) {
            final var currChar = s.charAt(right);

            if (charMap.containsKey(currChar)) {
                charMap.merge(currChar, -1, Integer::sum);
            }

            final var windowLen = right - left + 1;
            if (charsAllFound(charMap.values()) && windowLen < minLen) {
                minLen = windowLen;
                resultIndexes[0] = left;
                resultIndexes[1] = right;
            }

            while (charsAllFound(charMap.values())) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resultIndexes[0] = left;
                    resultIndexes[1] = right;                    
                }

                final var leftChar = s.charAt(left);

                if (charMap.containsKey(leftChar)) {
                    charMap.merge(leftChar, 1, Integer::sum);
                }

                left += 1;
            }

            right += 1;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resultIndexes[0], resultIndexes[1] + 1);
    }

    private boolean charsAllFound(Collection<Integer> freqs) {
        for (var frequency : freqs) {
            if (frequency > 0) {
                return false;
            }
        }
        return true;
    }
}
