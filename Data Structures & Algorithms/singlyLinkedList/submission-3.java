class LinkedList {

    private Node<Integer> root;
    private int size;

    public LinkedList() {
        this.root = new Node<>();
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }

        Node<Integer> currentNode = root.getNextNode();
        for(int i=0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }

    public void insertHead(int val) {
        Node<Integer> oldHead = root.getNextNode();
        root.setNextNode(new Node<>(val, oldHead));
        this.size++;
    }

    public void insertTail(int val) {
        Node<Integer> newNode = new Node<>(val, null);

        Node<Integer> currentNode = this.root;
        for(int i=0; i<this.size; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(newNode);
        this.size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= this.size) {
            return false;
        }
        
        Node<Integer> prevNode = this.root;
        Node<Integer> currentNode = root.getNextNode();

        for(int i=0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        prevNode.setNextNode(currentNode.getNextNode());
        this.size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();

        Node<Integer> currentNode = this.root.getNextNode();
        for (int i=0; i<this.size; i++) {
            result.add(currentNode.getValue());
            currentNode = currentNode.getNextNode();

        }

        return result;
    }

    class Node<T>{

        private T value;
        private Node<T> nextNode;

        Node() {

        }

        Node(T val, Node<T> nextNode) {
            this.value = val;
            this.nextNode = nextNode;
        }

        void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        Node<T> getNextNode() {
            return this.nextNode;
        }

        T getValue() {
            return this.value;
        }
    }
}
