class Solution {
    public int lengthOfLongestSubstring(String s) {
        final var usedChars = new HashSet<Character>();

        var maxLen = 0;

        var left = 0;
        for (var right = left; right < s.length(); right++) {
            final var currChar = s.charAt(right);

            while (usedChars.contains(currChar)) {
                usedChars.remove(s.charAt(left));
                left += 1;
            }

            usedChars.add(currChar);

            maxLen = Math.max(maxLen, usedChars.size());

        }

        return maxLen;
    }
}
