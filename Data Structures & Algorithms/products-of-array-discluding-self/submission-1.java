class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var LEN = nums.length;

        var result = new int[LEN];

        var leftToRightProduct = 1;
        for (var i = 0; i < LEN; i++) {
            result[i] = leftToRightProduct;
            leftToRightProduct *= nums[i];
        }

        var rightToLeftProduct = 1;
        for (var i = LEN - 1; i >= 0; i--) {
            result[i] *= rightToLeftProduct;
            rightToLeftProduct *= nums[i];
        }

        return result;
    }
}
