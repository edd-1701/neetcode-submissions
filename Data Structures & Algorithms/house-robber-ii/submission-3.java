/*


*/
class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, true), helper(nums, 1, false));
    }

    private int helper(int[] nums, int i, boolean robbedFirstHouse) {
        if (i >= nums.length || (i == nums.length - 1 && robbedFirstHouse)) {
            return 0;
        }

        final var memoKey = "" + i + "," + (robbedFirstHouse ? "true" : "false");

        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        final var robHouse = nums[i] + helper(nums, i + 2, robbedFirstHouse);
        final var robNext = helper(nums, i + 1, robbedFirstHouse);
        final var result = Math.max(robHouse, robNext);

        memo.put(memoKey, result);
        return result;
        
    }
}
