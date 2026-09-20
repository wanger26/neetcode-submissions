class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);

        while(!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        this.queue = temp;
    }
    
    public int pop() {
        return this.queue.poll();
    }
    
    public int top() {
        return this.queue.peek();
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
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