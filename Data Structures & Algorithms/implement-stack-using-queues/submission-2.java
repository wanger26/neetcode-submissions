class MyStack {

    private Queue<Object> queue;
    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Object> newQueue = new LinkedList<>();
        newQueue.add(x);
        newQueue.add(queue);

        queue = newQueue;
    }
    
    public int pop() {
        if (queue == null) {
            return -1;
        }

        int value = (int) queue.poll();
        queue = (Queue<Object>) queue.poll();

        return value;
    }
    
    public int top() {
        if(queue.peek() == null) {
            return -1;
        }

        return (int) queue.peek();
    }
    
    public boolean empty() {
        return queue.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */