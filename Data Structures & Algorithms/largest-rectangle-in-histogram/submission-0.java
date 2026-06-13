class Solution {
    public int largestRectangleArea(int[] heights) {

        final var LEN = heights.length;

        final var leftBounds = new int[LEN];
        final var rightBounds = new int[LEN];
        Arrays.fill(leftBounds, -1);
        Arrays.fill(rightBounds, LEN);

        final var stack = new Stack<Integer>();
        for (var i = 0; i < LEN; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rightBounds[stack.peek()] = i;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftBounds[i] = stack.peek();
            }

            stack.push(i);
        }


        var result = 0;
        for (var i = 0; i < LEN; i++) {
            final var currArea = (rightBounds[i] - leftBounds[i] - 1) * heights[i];

            if (currArea > result) {
                result = currArea;
            }
        }

        return result;
    }
}
