class Solution {
    public int[] plusOne(int[] digits) {
        
        var carryTheOne = false;
        var result = new ArrayList<Integer>();
        for (var i = digits.length - 1; i >= 0; i--) {
            var num = digits[i] + (i == digits.length - 1 ? 1 : 0);
            num += carryTheOne ? 1 : 0;

            carryTheOne = num > 9;
            num -= carryTheOne ? 10 : 0;

            result.addFirst(num);
        }
        if (carryTheOne) {
            result.addFirst(1);
        }

        final var result2 = new int[result.size()];
        for (var i = 0; i < result.size();i++) {
            result2[i] = result.get(i);
        }

        return result2;

    }
}
