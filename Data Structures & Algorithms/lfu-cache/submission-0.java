class LFUCache {
    private final int capacity;
    private int currentSize;
    private final Bucket leastUsed;
    private final Bucket mostUsed;
    private final Map<Integer, Bucket> keyToBucket;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.keyToBucket = new HashMap<>();
        this.leastUsed = new Bucket(0);
        this.mostUsed = new Bucket(Integer.MAX_VALUE);
        this.leastUsed.next = mostUsed;
        this.mostUsed.previous = leastUsed;
    }

    public int get(int key) {
        if (!keyToBucket.containsKey(key)) return -1;
        Bucket bucket = keyToBucket.get(key);
        int value = bucket.keyToValue.get(key);
        increment(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToBucket.containsKey(key)) {
            increment(key, value);
        } else {
            if (currentSize >= capacity) {
                evict();
            }
            
            Bucket freqOneBucket;
            if (leastUsed.next.count == 1) {
                freqOneBucket = leastUsed.next;
            } else {
                freqOneBucket = new Bucket(1);
                insertBucketAfter(leastUsed, freqOneBucket);
            }

            freqOneBucket.keyToValue.put(key, value);
            keyToBucket.put(key, freqOneBucket);
            currentSize++;
        }
    }

    private void increment(int key, int newValue) {
        Bucket currentBucket = keyToBucket.get(key);
        currentBucket.keyToValue.remove(key);

        int nextCount = currentBucket.count + 1;
        Bucket nextBucket = currentBucket.next;

        if (nextBucket.count != nextCount) {
            nextBucket = new Bucket(nextCount);
            insertBucketAfter(currentBucket, nextBucket);
        }

        nextBucket.keyToValue.put(key, newValue);
        keyToBucket.put(key, nextBucket);

        if (currentBucket.keyToValue.isEmpty()) {
            unlinkBucket(currentBucket);
        }
    }

    private void evict() {
        Bucket lowestBucket = leastUsed.next;
        int keyToEvict = lowestBucket.keyToValue.keySet().iterator().next();
        
        lowestBucket.keyToValue.remove(keyToEvict);
        keyToBucket.remove(keyToEvict);
        
        if (lowestBucket.keyToValue.isEmpty()) {
            unlinkBucket(lowestBucket);
        }
        currentSize--;
    }

    private void insertBucketAfter(Bucket prev, Bucket newBucket) {
        newBucket.previous = prev;
        newBucket.next = prev.next;
        prev.next.previous = newBucket;
        prev.next = newBucket;
    }

    private void unlinkBucket(Bucket bucket) {
        bucket.previous.next = bucket.next;
        bucket.next.previous = bucket.previous;
    }

    private class Bucket {
        int count;
        Map<Integer, Integer> keyToValue = new LinkedHashMap<>();
        Bucket previous = null;
        Bucket next = null;

        Bucket(int count) {
            this.count = count;
        }
    }
}