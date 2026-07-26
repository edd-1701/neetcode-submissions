class Solution {
    public int[] countBits(int n) {
        final var result = new int[n + 1];
        for (var i = 0; i <= n; i++) {
            var bits = 0;
            var num = i;
            while (num > 0) {
                num &= (num - 1);

                bits += 1;
            }

            result[i] = bits;
        }

        return result;
    }
}
