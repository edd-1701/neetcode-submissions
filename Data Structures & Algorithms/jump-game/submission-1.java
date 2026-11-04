class Solution {
    public boolean canJump(int[] nums) {
        var furthestIdx = 0;
        for (var i = 0; i < nums.length; i++) {
            if (i > furthestIdx) {
                return false;
            }

            furthestIdx = Math.max(furthestIdx, i + nums[i]);

            if (furthestIdx >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
