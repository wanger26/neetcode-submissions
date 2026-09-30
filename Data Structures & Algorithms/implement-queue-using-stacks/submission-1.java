class MyQueue {

    private final Stack<Integer> stackOrder;
    private final Stack<Integer> queueOrder;

    public MyQueue() {
        stackOrder = new Stack<>();
        queueOrder = new Stack<>();
    }
    
    public void push(int x) {
        stackOrder.push(x);
    }
    
    public int pop() {
        if(queueOrder.isEmpty()) {
            while(!stackOrder.isEmpty()) {
                queueOrder.add(stackOrder.pop());
            }
        }

        return queueOrder.pop();
    }
    
    public int peek() {
        if(queueOrder.isEmpty()) {
            while(!stackOrder.isEmpty()) {
                queueOrder.add(stackOrder.pop());
            }
        }

        return queueOrder.peek();
    }
    
    public boolean empty() {
        return queueOrder.isEmpty() && stackOrder.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */