class Solution {
    private final static String ZERO = "0";

    public String multiply(String num1, String num2) {
        if (num1.equals(ZERO) || num2.equals(ZERO)) {
            return ZERO;
        }

        final var result = new int[num1.length() + num2.length()];

        final var n1 = new StringBuilder(num1);
        n1.reverse();

        final var n2 = new StringBuilder(num2);
        n2.reverse();

        for (var i = 0; i < n1.length(); i++) {
            for (var j = 0; j < n2.length(); j++) {
                final var numAt1 = n1.charAt(i) - '0';
                final var numAt2 = n2.charAt(j) - '0';
                final var product = numAt1 * numAt2;

                result[i + j] += product;
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }

        final var resultStr = new StringBuilder();
        var i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i -= 1;
        }

        while (i >= 0) {
            resultStr.append(result[i--]);
        }

        return resultStr.toString();
    }
}
