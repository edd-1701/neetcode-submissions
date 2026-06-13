class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        var left = 0;
        var right = left + 1;
        var result = 1;
        var charSet = new HashSet<Character>();
        charSet.add(s.charAt(0));

        while (left <= right && right < s.length()) {
            //keep moving right until we find that we can't add the next one

            if (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left += 1;
            } else {
                charSet.add(s.charAt(right));

                result = Math.max(result, right - left + 1);
                right += 1;
            }



        }


        return result;

    }
}
