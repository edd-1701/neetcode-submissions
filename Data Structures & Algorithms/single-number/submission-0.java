class Solution {
    public int singleNumber(int[] nums) {
        
        var result = nums[0];

        for (var i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
