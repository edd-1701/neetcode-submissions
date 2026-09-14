class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final var result = new int[temperatures.length];

        final var stack = new Stack<Integer>();
        stack.push(0);
        for (var i = 1; i < temperatures.length; i++) {
            final var currTemp = temperatures[i];

            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}
