class Solution {
    public boolean canJump(int[] nums) {

        var leftMostReachable = nums.length - 1;

        for (var i = nums.length - 2; i>=0; i--) {
            if (i + nums[i] >= leftMostReachable) {
                leftMostReachable = i;
            }
        }

        return leftMostReachable == 0;

    }
}
