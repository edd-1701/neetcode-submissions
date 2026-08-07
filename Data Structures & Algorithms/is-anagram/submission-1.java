/*
    Count frequency, and compare
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final var sChars = new int[26];
        final var tChars = new int[26];

        for (var i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a'] += 1;
            tChars[t.charAt(i) - 'a'] += 1;
        }

        for (var i = 0; i < 26; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
