class Solution {
    public boolean isAnagram(String s, String t) {
        final var sChars = s.toCharArray();
        final var tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
