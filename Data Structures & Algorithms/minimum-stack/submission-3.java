/*
    Two stacks

*/

class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        data.push(val);

        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }

        final var popped = data.pop();
        if (minStack.peek().equals(popped)) {
            minStack.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
