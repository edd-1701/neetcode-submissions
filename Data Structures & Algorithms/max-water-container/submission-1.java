class Solution {
    public int maxArea(int[] heights) {
        var result = 0;

        var left = 0;
        var right = heights.length - 1;

        while (left < right) {
            var width = right - left;
            var height = Math.min(heights[left], heights[right]);
            final var area = width * height;

            result = Math.max(result, area);

            if (heights[left] <= heights[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return result;
    }
}
