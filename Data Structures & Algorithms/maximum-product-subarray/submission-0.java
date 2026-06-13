class Solution {
    public int maxProduct(int[] nums) {
        var result = nums[0];

        for (var i = 0; i < nums.length; i++) {
            var currProduct = nums[i];
            result = Math.max(result, currProduct);
            for (var j = i + 1; j < nums.length; j++) {
                currProduct *= nums[j];

                if (currProduct > result) {
                    result = currProduct;
                }
            }
        }

        return result;
    }
}
