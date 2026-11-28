class MinStack {
    private final Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.peek()[1];
    }
}
