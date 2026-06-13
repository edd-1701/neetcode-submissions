class Solution {
    private static final int CHAR_ARR_OFFSET = 65;

    public int characterReplacement(String s, int k) {

        var result = 0;

        var l = 0;
        // var frequencies = new HashMap<Character, Integer>();
        final var frequencies = new int[26];
        var maxCharFrequency = 0;
        for (var r = 0; r < s.length(); r++) {
            final var currChar = s.charAt(r);
            final var arrayIndex = currChar - 0 - CHAR_ARR_OFFSET;
            
            frequencies[arrayIndex] += 1;
            // frequencies.merge(currChar, 1, Integer::sum);

            maxCharFrequency = Math.max(maxCharFrequency, frequencies[arrayIndex]);

            while ((r - l + 1) - maxCharFrequency > k) {
                // frequencies.merge(s.charAt(l), -1, Integer::sum);
                frequencies[s.charAt(l) - 0 - CHAR_ARR_OFFSET] -= 1;

                l += 1;
            }

            result = Math.max(result, r - l + 1);

        }

        return result;


    }
}


/* 
      A A A B A B B

      l, r = 0, k = 1

      A     A     A     B     A     B     B
     l r
      k=1
    
    if k

*/