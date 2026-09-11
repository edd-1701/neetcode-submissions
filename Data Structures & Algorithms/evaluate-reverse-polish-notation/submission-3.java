class Solution {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIV = "/";
    private static final List<String> OPERATORS = List.of(ADD, SUBTRACT, MULTIPLY, DIV);

    public int evalRPN(String[] tokens) {
        
        final var stack = new ArrayDeque<Integer>();

        for (var token : tokens) {
            if (OPERATORS.contains(token)) {
                stack.push(calculate(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static int calculate(int right, int left, String operator) {
        if (ADD.equals(operator)) {
            return left + right;
        } else if (SUBTRACT.equals(operator)) {
            return left - right;
        } else if (MULTIPLY.equals(operator)) {
            return left * right;
        } else {
            return left / right;
        }
    }
}
