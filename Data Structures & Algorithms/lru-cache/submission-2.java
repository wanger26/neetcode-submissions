class LRUCache {

    private int capacity;
    private final Node firstNode;
    private final Node lastNode;
    private final Map<Integer, Node> keyToNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.firstNode = new Node(null, null);
        this.lastNode = new Node(null, null);
        this.firstNode.setNextNode(lastNode);
        this.lastNode.setPrevNode(firstNode);
        this.keyToNodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyToNodeMap.get(key);
        moveToBack(keyToNodeMap.get(key));
        return node.getValue();
    }
    
    public void put(int key, int value) {

        if (keyToNodeMap.containsKey(key)) {
            moveToBack(keyToNodeMap.get(key));
            keyToNodeMap.get(key).setValue(value);
        } else {
            this.capacity--;
            Node newNode = new Node(key, value);
            addNode(newNode);
            keyToNodeMap.put(key, newNode);

            if(capacity == -1) {
                Node lastRecentlyUsed = firstNode.getNextNode();
                removeNode(lastRecentlyUsed);
                keyToNodeMap.remove(lastRecentlyUsed.getKey());
                capacity++;
            }
        }
    }

    private void moveToBack(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        Node prevLastNode = lastNode.getPrevNode();

        prevLastNode.setNextNode(node);
        node.setPrevNode(prevLastNode);
        node.setNextNode(lastNode);
        lastNode.setPrevNode(node);
    }

    private void removeNode(Node node) {
        Node prevNode = node.getPrevNode();
        Node nextNodeNode = node.getNextNode();

        prevNode.setNextNode(nextNodeNode);
        nextNodeNode.setPrevNode(prevNode);
    }

    class Node {
        private final Integer key;
        private Integer value;
        private Node prevNode;
        private Node nextNode;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        void setValue(int value) {
            this.value = value;
        }

        void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        Integer getKey() {
            return key;
        }

        Integer getValue() {
            return value;
        }

        Node getNextNode() {
            return nextNode;
        }

        Node getPrevNode() {
            return prevNode;
        }
    }
}
