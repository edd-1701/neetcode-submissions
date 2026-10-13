class Solution {
    public int maxSubArray(int[] nums) {
        var result = nums[0];
        var currSum = 0;

        for (var num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }

            currSum += num;
            result = Math.max(result, currSum);
        }



        return result;
    }
}
