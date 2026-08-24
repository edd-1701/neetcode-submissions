class Solution {
    public String minWindow(String s, String t) {
        final var charCounts = new int[(26 * 2) + 10];

        for (var i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'A'] += 1;
        }

        var minWindow = Integer.MAX_VALUE;
        var resultIdxs = new int[2];

        var left = 0;
        var right = 0;
        while (right < s.length()) {
            final var currChar = s.charAt(right);

            charCounts[currChar - 'A'] -= 1;

            while (hasAll(charCounts)) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    resultIdxs[0] = left;
                    resultIdxs[1] = right;
                }

                charCounts[s.charAt(left) - 'A'] += 1;

                left += 1;
            }

            right += 1;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(resultIdxs[0], resultIdxs[1] + 1);
    }

    private static boolean hasAll(int[] counts) {
        for (var c : counts) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
