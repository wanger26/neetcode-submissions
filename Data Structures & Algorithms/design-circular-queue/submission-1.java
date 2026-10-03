class MyCircularQueue {

    private Node front;
    private Node rear;
    private int size;
    private int maxSize;

    public MyCircularQueue(int k) {
        // Start with no nodes instead of empty dummy nodes
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        Node newNode = new Node();
        newNode.value = value;

        if (isEmpty()) {
            // First element becomes both front and rear
            front = newNode;
            rear = newNode;
        } else {
            // Append to the current rear, then move the rear pointer
            rear.nextNode = newNode;
            newNode.prevNode = rear;
            rear = newNode; 
        }

        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (this.size == 1) {
            // Queue becomes empty
            front = null;
            rear = null;
        } else {
            // Move the front pointer to the next node in line
            front = front.nextNode;
            front.prevNode = null; 
        }

        this.size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return this.front.value;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return this.rear.value;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == maxSize;
    }

    public class Node {
        public int value;
        public Node nextNode;
        public Node prevNode;
    }
}