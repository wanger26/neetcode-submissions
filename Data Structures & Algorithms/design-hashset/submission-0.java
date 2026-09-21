class MyHashSet {
    private static final int HASH_KEY = 2069;
    private List<Integer>[] hashTable;

    public MyHashSet() {
        this.hashTable = new List[HASH_KEY];
    }

    public void add(int key) {
        int hashKey = hash(key);
        if (hashTable[hashKey] == null) {
            hashTable[hashKey] = new LinkedList<>();
            hashTable[hashKey].add(key);
            return;
        }

        for (int value : hashTable[hashKey]) {
            if (value == key) {
                return;
            }
        }
        hashTable[hashKey].add(key);
    }

    public void remove(int key) {
        int hashKey = hash(key);
        if (hashTable[hashKey] == null) {
            return;
        }

        List<Integer> keys = hashTable[hashKey];
        for (int i = 0; i < keys.size(); i++) {
            if (key == keys.get(i)) {
                keys.remove(i);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        if (hashTable[hashKey] == null) {
            return false;
        }

        List<Integer> keys = hashTable[hashKey];
        for (int i = 0; i < keys.size(); i++) {
            if (key == keys.get(i)) {
                return true;
            }
        }

        return false;
    }

    private int hash(int key) {
        return key % HASH_KEY;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */