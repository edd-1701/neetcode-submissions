class Solution {
    public int reverseBits(int n) {
        var result = 0;
        var bit = 0;

        while (bit <= 31 && n != 0) {
            //select the least significant bit
            final var lsb = n & 1;

            //take the lsb and apply a mask to put it in the reversed position
            final var mirrored = lsb << (31 - bit);

            //do bitwise OR to assign to result
            result |= mirrored;

            n >>>= 1;
            bit += 1;
        }


        return result;
    }
}
