class Solution {
    public int[] plusOne(int[] digits) {
        final var LEN = digits.length;

        if (digits[LEN - 1] < 9) {
            digits[LEN - 1] += 1;
            return digits;
        }

        final var result = new ArrayList<Integer>();

        var i = LEN - 1;
        var carry = 1;
        while (i >= 0) {
            final var newSum = digits[i] + carry;
            result.addFirst(newSum > 9 ? (10 - newSum) : newSum);
            carry = newSum > 9 ? 1 : 0;
            i -= 1;
        }

        if (carry == 1) {
            result.addFirst(1);
        }

        final var res = new int[result.size()];
        for (var j = 0; j < res.length; j++) {
            res[j] = result.get(j);
        }

        return res;
    }
}
