/**

    At each point find the left and right boundary of the rectangle
        (how far left and right you can go)
    leftBound = int[] (default to -1, 0 is a valid value)
    rightBound = int[] (default to len(heights))

    create a stack


*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        final var LEN = heights.length;

        final var lBounds = new int[LEN];
        final var rBounds = new int[LEN];
        Arrays.fill(lBounds, -1);
        Arrays.fill(rBounds, LEN);

        final var stack = new Stack<Integer>();
        for (var i = 0; i < LEN; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                rBounds[stack.peek()] = i;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                lBounds[i] = stack.peek();
            }

            stack.push(i);
        }

        var result = 0;
        for (var i = 0; i < LEN; i++) {
            final var width = rBounds[i] - lBounds[i] - 1;
            final var height = heights[i];
            final var area = width * height;
            result = Math.max(result, area);
        }

        return result;
    }
}
