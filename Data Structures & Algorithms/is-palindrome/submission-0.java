class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        var left = 0;
        var right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            }

            // System.out.println("Comparing [%s] and [%s]".formatted(s.charAt(left), s.charAt(right)));

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }


            left += 1;
            right -= 1;
        }

        return true;
    }
}
