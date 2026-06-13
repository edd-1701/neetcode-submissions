class Solution {
    public int characterReplacement(String s, int k) {

        var result = 0;

        var l = 0;
        var frequencies = new HashMap<Character, Integer>();
        var maxCharFrequency = 0;
        for (var r = 0; r < s.length(); r++) {
            final var currChar = s.charAt(r);
            frequencies.merge(currChar, 1, Integer::sum);
            maxCharFrequency = Math.max(maxCharFrequency, frequencies.get(currChar));

            while ((r - l + 1) - maxCharFrequency > k) {
                frequencies.merge(s.charAt(l), -1, Integer::sum);
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