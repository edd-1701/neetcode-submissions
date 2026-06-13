class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);

        return helper(n);
    }

    private int helper(int floor) {
        if (cache.containsKey(floor)) {
            return cache.get(floor);
        }
        final var result = helper(floor-2) + helper(floor-1);
        cache.put(floor, result);
        return result;
    }
}
