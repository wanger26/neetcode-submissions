class MyHashMap {
    private static final int BASE = 2069; // Prime number to minimize collisions
    private Node[] buckets;

    public MyHashMap() {
        this.buckets = new Node[BASE];
    }

    public void put(int key, int value) {
        Node node = buckets[hash(key)];

        Node prevNode = null;
        while (node != null && node.key != key) {
            prevNode = node;
            node = node.next;
        }

        if (node == null) {
            Node newNode = new Node(key, value);
            if(prevNode != null) {
                prevNode.next = newNode;
            } else {
                buckets[hash(key)] = newNode;
            }
        } else {
            node.val = value;
        }
    }

    public int get(int key) {
        Node node = buckets[hash(key)];

        while (node != null && node.key != key) {
            node = node.next;
        }

        return node == null ? -1 : node.val;
    }

    public void remove(int key) {
        Node node = buckets[hash(key)];
        Node prevNode = null;

        while (node != null && node.key != key) {
            prevNode = node;
            node = node.next;
        }

        if (node != null && prevNode != null) {
            prevNode.next = node.next;
        }

        buckets[hash(key)] = prevNode;
    }

    private class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */