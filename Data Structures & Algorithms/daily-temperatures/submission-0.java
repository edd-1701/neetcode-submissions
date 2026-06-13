class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final var result = new int[temperatures.length];
        final var stack = new Stack<Integer>();
        for (var i = 0; i < temperatures.length; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    final var colderIndex = stack.pop();
                    result[colderIndex] = i - colderIndex;
                }
                stack.push(i);
            }
        }

        return result;
    }
}
