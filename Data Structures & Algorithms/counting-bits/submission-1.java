class Solution {
    public int[] countBits(int n) {
        final var result = new int[n+1];

        for (var num = 0; num <= n; num++) {
            for (var i = 0; i < 32; i++) {
                final var hasOne = (num & (1 << i)) != 0;
                if (hasOne) {
                    result[num] += 1;
                }
            }
        }


        return result;
    }
}
