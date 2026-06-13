class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        } else if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }

        final var isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }

        final var digits = new ArrayList<String>();
        while (x > 0) {
            digits.add(String.valueOf(x % 10));
            x /= 10;
        }

        var longVal = Long.valueOf(String.join("", digits));
        longVal *= isNegative ? -1 : 1;

        if (isNegative && longVal < Integer.MIN_VALUE) {
            return 0;
        } else if (!isNegative && longVal > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)longVal.longValue();
        }
    }
}
