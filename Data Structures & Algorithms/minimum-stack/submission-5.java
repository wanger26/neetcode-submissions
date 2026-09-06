class MinStack {

    private long min;
    private Stack<Long> stack;

    public MinStack() {
        this.stack = new Stack<>();   
        this.min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if(val < min) {
                min = val;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) {
           return;
        }

        long value = stack.pop();
        if(value < 0) {
            min = min - value;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
