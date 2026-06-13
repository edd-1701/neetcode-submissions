class Solution {
    public int maxArea(int[] heights) {
        var maxArea = 0;

        var l = 0;
        var r = heights.length - 1;
        while (l < r) {
            var currentArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(currentArea, maxArea);

            if (heights[l] <= heights[r]) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        return maxArea;
    }
}
