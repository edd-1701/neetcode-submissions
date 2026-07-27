class Solution {
    public boolean isHappy(int n) {
        final var visited = new HashSet<Integer>();

        while (visited.add(n)) {
            n = sumOfSquaredDigits(n);

            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int sumOfSquaredDigits(int num) {
        var result = 0;

        while (num > 0) {
            final var digit = num % 10;
            result += (digit * digit);
            num /= 10;
        }

        return result;
    }
}
