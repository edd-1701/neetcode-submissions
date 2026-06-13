class MinStack {
    /*
        stack : keeps track of the items
        integer: min keeps track of the smalelst elem
    */

    Stack<Integer> data;
    Stack<Integer> minStack;
    // Integer min;

    public MinStack() {
        data = new Stack<>();
        minStack = new Stack<>();
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        data.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (data.isEmpty()) {
            return;
        }

        final var top = data.pop();
        if (top.equals(minStack.peek())) {
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
