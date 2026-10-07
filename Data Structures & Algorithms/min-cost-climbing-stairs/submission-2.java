class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(0, cost), helper(1, cost));
    }

    private int helper(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        } else if (cache.containsKey(i)) {
            return cache.get(i);
        }

        final var singleStepCost = helper(i + 1, cost);
        final var doubleStepCost = helper(i + 2, cost);

        final var result = cost[i] + Math.min(singleStepCost, doubleStepCost);
        cache.put(i, result);
        return result;
    }
}
