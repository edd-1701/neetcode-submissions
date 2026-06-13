class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final var charMap = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            final var chr = s.charAt(i);
            charMap.merge(chr, 1, Integer::sum);
        }

        for (var i = 0; i < t.length(); i++) {
            final var chr = t.charAt(i);
            final var frequency = charMap.get(chr);
            if (frequency == null || frequency == 0) {
                return false;
            }

            if (frequency == 1) {
                charMap.remove(chr);
            } else {
                charMap.put(chr, frequency - 1);
            }
        }

        return charMap.isEmpty();
    }
}
