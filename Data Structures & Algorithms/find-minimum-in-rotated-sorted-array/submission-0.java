class Solution {
    public int findMin(int[] nums) {
        
        var minNum = nums[0];

        for (var i = 1; i < nums.length; i++) {
            if (nums[i] < minNum) {
                minNum = nums[i];
            }
        }

        return minNum;
    }
}
