/*

This is a sliding window problem



freqs = int[26] // array containing the character frequencies
maxCharFrequency // frequency of the char with the max freq so far
left = 0
right = 0
result = 0
while right < len(s):
    add char at right to frequencies

    update maxCharFrequency


    while window minus maxCharFrequency is greater than k
        decrement freqs[leftChar]
        move left forward

    update result to max(result, r - l + 1)

*/
class Solution {
    public int characterReplacement(String s, int k) {
        final var freqs = new int[26];
        var maxFreqCharLen = 0;
        var result = 0;
        var left = 0;
        var right = 0;

        while (right < s.length()) {
            final var currChar = s.charAt(right);
            freqs[currChar - 'A'] += 1;
            maxFreqCharLen = Math.max(maxFreqCharLen, freqs[currChar - 'A']);

            while ((right - left + 1) - maxFreqCharLen > k) {
                freqs[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }

            result = Math.max(result, right - left + 1);

            right += 1;
        }

        return result;
    }
}
