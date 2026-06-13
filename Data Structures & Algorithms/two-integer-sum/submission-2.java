class Solution {
    public int[] twoSum(int[] nums, int target) {

        final var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            final var complementIndex = map.get(nums[i]);
            if (complementIndex != null) {
                return new int[]{complementIndex, i};
            }

            map.put(target - nums[i], i);
        }

        return new int[]{0,0};
    }
}
