class Solution {
    public int trap(int[] height) {
        final var LEN = height.length;

        final var maxLefts = new int[LEN];
        for (var i = 1; i < LEN; i++) {
            maxLefts[i] = Math.max(height[i - 1], maxLefts[i - 1]);
        }

        final var maxRights = new int[LEN];
        for (var i = LEN - 2; i >= 0; i--) {
            maxRights[i] = Math.max(height[i + 1], maxRights[i + 1]);
        }

        var totalWater = 0;
        for (var i = 0; i < LEN; i++) {
            final var maxWaterLevel = Math.min(maxLefts[i], maxRights[i]);
            final var netWater = maxWaterLevel - height[i];

            if (netWater > 0) {
                totalWater += netWater;
            }
        }

        return totalWater;
    }
}
