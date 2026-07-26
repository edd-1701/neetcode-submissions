class Solution {
    public int reverseBits(int n) {
        final var bits = new ArrayList<Integer>();
        for (var i = 0; i < 32; i++) {
            final var mask = 1 << i;
            bits.add((n & mask) != 0 ? 1 : 0);
        }

        Collections.reverse(bits);
        var result = 0;
        for (var i = 0; i < 32; i++) {
            if (bits.get(i) == 1) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
