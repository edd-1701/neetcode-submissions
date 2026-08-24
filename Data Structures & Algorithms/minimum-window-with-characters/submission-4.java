class Solution {
    public String minWindow(String s, String t) {
        // final var charMap = new HashMap<Character, Integer>();
        final var charCounts = new int[(26 * 2) + 10];

        for (var i = 0; i < t.length(); i++) {
            // charMap.merge(t.charAt(i), 1, Integer::sum);
            charCounts[t.charAt(i) - 'A'] += 1;
        }

        var minWindow = Integer.MAX_VALUE;
        var resultIdxs = new int[2];

        var left = 0;
        var right = 0;
        while (right < s.length()) {
            final var currChar = s.charAt(right);

            // charMap.merge(currChar, -1, Integer::sum);
            charCounts[currChar - 'A'] -= 1;

            // while (hasAll(charMap.values())) {
            while (hasAllArr(charCounts)) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    resultIdxs[0] = left;
                    resultIdxs[1] = right;
                }

                // charMap.merge(s.charAt(left), 1, Integer::sum);
                charCounts[s.charAt(left) - 'A'] += 1;

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

    private static boolean hasAllArr(int[] counts) {
        for (var c : counts) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
