class Solution {
    private String s;
    private int maxLen = 0;
    private int resultLeftIdx = 0;
    private int resultRightIdx = 0;

    public String longestPalindrome(String s) {
        this.s = s;

        for (var i = 0; i < s.length(); i++) {
            for (var j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j) || !isPalindrome(i, j)) {
                    continue;
                }

                if (j - i > maxLen) {
                    maxLen = j - i;
                    resultLeftIdx = i;
                    resultRightIdx = j;
                }

            }
        }


        return s.substring(resultLeftIdx, resultRightIdx+1);
    }

    private boolean isPalindrome(int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;

    }
}
