class MyCircularQueue {
    
    private int[] data;
    private int front;
    private int size;
    private int maxSize;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.front = 0;
        this.size = 0;
        this.maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        // Calculate the rear index using modulo arithmetic to wrap around
        int rear = (front + size) % maxSize;
        data[rear] = value;
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        
        // Move front pointer forward, wrapping around if it hits the end
        front = (front + 1) % maxSize;
        size--;
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) { 
            return -1;
        }
        return data[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        // Calculate the current rear index
        int rear = (front + size - 1) % maxSize;
        return data[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}