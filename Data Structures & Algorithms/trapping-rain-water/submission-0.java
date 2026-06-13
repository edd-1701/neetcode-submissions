class Solution {
    public int trap(int[] height) {
        
        final var maxLefts = new int[height.length];
        for (var i = 1; i < height.length; i++) {
            maxLefts[i] = Math.max(maxLefts[i-1], height[i-1]);           
        }

        final var maxRights = new int[height.length];
        for (var i = height.length - 2; i >= 0; i--) {
            maxRights[i] = Math.max(maxRights[i+1], height[i+1]);           
        }

        var maxArea = 0;
        for (var i = 0; i < height.length; i++) {
            final var currArea = Math.min(maxLefts[i], maxRights[i]) - height[i];

            if (currArea > 0) {
                maxArea += currArea;
            }
        }

        return maxArea;
    }
}
