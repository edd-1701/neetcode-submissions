class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (var i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}