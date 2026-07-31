class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        final var result = customPow(x, Math.abs((long) n));
        return n > 0 ? result : 1 / result;
    }

    private double customPow(double base, long exp) {
        if (exp == 0) {
            return 1;
        }

        final var halvedResult = customPow(base, exp / 2);

        var result = halvedResult * halvedResult;
        if (exp % 2 == 1) {
            result *= base;
        }

        return result;
    }
}
