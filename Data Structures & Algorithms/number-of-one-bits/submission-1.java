class Solution {
    public int hammingWeight(int n) {
        var result = 0;

        for (var i = 0; i < 32; i++) {
            result += (n & (1 << i)) != 0 ? 1 : 0;
        }

        return result;
    }
}
