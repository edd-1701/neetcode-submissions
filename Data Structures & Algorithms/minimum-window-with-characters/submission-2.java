class Solution {
    public String minWindow(String s, String t) {
        final var charMap = new HashMap<Character, Integer>();

        for (var i = 0; i < t.length(); i++) {
            charMap.merge(t.charAt(i), 1, Integer::sum);
        }

        var minWindow = Integer.MAX_VALUE;
        var resultIdxs = new int[2];

        var left = 0;
        var right = 0;
        while (right < s.length()) {
            final var currChar = s.charAt(right);

            charMap.merge(currChar, -1, Integer::sum);

            final var windowLen = right - left + 1;
            if (hasAll(charMap.values()) && windowLen < minWindow) {
                minWindow = windowLen;
                resultIdxs[0] = left;
                resultIdxs[1] = right;
            }

            while (hasAll(charMap.values())) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    resultIdxs[0] = left;
                    resultIdxs[1] = right;
                }

                charMap.merge(s.charAt(left), 1, Integer::sum);

                left += 1;
            }

            right += 1;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(resultIdxs[0], resultIdxs[1] + 1);
    }

    private static boolean hasAll(Collection<Integer> counts) {
        for (var c : counts) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
