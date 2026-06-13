class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var result = new int[nums.length];

        var leftToRightProduct = 1;
        for (var i = 0; i < nums.length; i++) {
            result[i] = leftToRightProduct;
            leftToRightProduct *= nums[i];
        }

        var rightToLeftProduct = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightToLeftProduct;
            rightToLeftProduct *= nums[i];
        }

        return result;
    }
}  
