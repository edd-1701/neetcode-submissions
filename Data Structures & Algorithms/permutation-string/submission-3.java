class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        final var charMap = new HashMap<Character, Integer>();
        for (var i = 0; i < s1.length(); i++) {
            charMap.merge(s1.charAt(i), 1, Integer::sum);
        }

        final var searchMap = new HashMap<Character, Integer>();
        for (var i = 0; i < s1.length(); i++) {
            searchMap.merge(s2.charAt(i), 1, Integer::sum);
        }

        var left = 0;
        var right = s1.length() - 1;
        while (right < s2.length() - 1) {
            if (charMap.equals(searchMap)) {
                return true;
            }

            final var newLeftFreq = searchMap.merge(s2.charAt(left), -1, Integer::sum);
            if (newLeftFreq == 0) {
                searchMap.remove(s2.charAt(left));
            }
            left += 1;

            right += 1;
            searchMap.merge(s2.charAt(right), 1, Integer::sum);
        }

        return charMap.equals(searchMap);
    }
}
