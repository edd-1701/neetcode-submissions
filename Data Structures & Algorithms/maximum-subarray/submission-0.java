class Solution {
    public int maxSubArray(int[] nums) {
        var max = nums[0];
        for (var i = 0; i< nums.length; i++) {
            var sum = 0;
            for (var j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
