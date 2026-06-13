class Solution {
    private Map<Integer, Integer> cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new HashMap<>();

        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    private int helper(int[] cost, int indexAt) {
        if (indexAt >= cost.length) {
            return 0;
        } else if (cache.containsKey(indexAt)) {
            return cache.get(indexAt);
        }

        final var oneStepCost = helper(cost, indexAt + 1);
        final var twoStepCost = helper(cost, indexAt + 2);
        final var result = cost[indexAt] + Math.min(oneStepCost, twoStepCost);

        cache.put(indexAt, result);
        return result;
    }
}
