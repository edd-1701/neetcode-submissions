class Solution {    
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIV = "/";
    private static final List<String> OPERATORS = List.of(ADD, SUBTRACT, MULTIPLY, DIV);

    public int evalRPN(String[] tokens) {

        final var stack = new Stack<Integer>();
        for (final var token : tokens) {
            // System.out.println("\tstack len: %s, stack: %s".formatted(stack.size(), stack));
            if (OPERATORS.contains(token)) {
                stack.push(doArithmetic(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        // System.out.println("Stack len: %s, stack: %s".formatted(stack.size(), stack));
        return stack.pop();

    }

    private static int doArithmetic(final int right, final int left, final String operation) {
        // System.out.println("left: %s, right:%s, op: %s".formatted(left, right, operation));
        if (operation.equals(ADD)) {
            return left + right;
        } else if (operation.equals(SUBTRACT)) {
            return left - right;
        } else if (operation.equals(MULTIPLY)) {
            return left * right;
        } else {
            return left / right;
        }
    }
}