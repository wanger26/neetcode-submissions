class MyLinkedList {
    class Node {
        Node next;
        int value;
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        this.size = 0;
    }

    // Time: O(n)
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }

        Node current = getNode(index+1);
        return current.value;
    }

    // Time: O(1)
    public void addAtHead(int val) {
        Node temp = this.head.next;
        Node newNode = new Node();
        newNode.next = temp;
        newNode.value = val;

        this.head.next = newNode;
        this.size++;
    }

    // Time: O(1)
    public void addAtTail(int val) {
        this.tail.value = val;
        this.tail.next = new Node();

        this.tail = tail.next;
        this.size++;
    }

    // Time: O(n)
    public void addAtIndex(int index, int val) {
        if (index == 0 || this.size == 0) {
            addAtHead(val);
        } else if (index == this.size) {
            addAtTail(val);
        } else {
            Node current = getNode(index);
            Node temp = current.next;
            Node newNode = new Node();
            newNode.next = temp;
            newNode.value = val;

            current.next = newNode;
            this.size++;
        }

    }

    // Time: O(n)
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        } else if (index == 0) {
            this.head.next = this.head.next.next;
        } else {
            Node current = getNode(index);
            current.next = current.next.next;
        }

        this.size--;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */