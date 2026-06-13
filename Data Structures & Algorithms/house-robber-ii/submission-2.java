class Solution {
    private Map<Integer, Map<Boolean, Integer>> cache = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(helper(nums, 0, true), helper(nums, 1, false));
    }

    //I can rob first house, and subtract last house (since connceted)

    private int helper(int[] houses, int indexAt, boolean robbedFirstHouse) {
        if (indexAt >= houses.length || (robbedFirstHouse && indexAt == houses.length - 1)) {
            return 0;
        }

        if (cache.computeIfAbsent(indexAt, k -> new HashMap<>()).containsKey(robbedFirstHouse)) {
            return cache.get(indexAt).get(robbedFirstHouse);
        }
        

        //rob current house, and subtra
        final var robCurrent = houses[indexAt] + helper(houses, indexAt + 2, robbedFirstHouse);
        final var robNext =  helper(houses, indexAt + 1, robbedFirstHouse);

        final var result = Math.max(robCurrent, robNext);
        cache.get(indexAt).put(robbedFirstHouse, result);
        return result;
    }
}
