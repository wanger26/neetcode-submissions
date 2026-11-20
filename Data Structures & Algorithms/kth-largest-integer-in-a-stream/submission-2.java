class KthLargest {
    private PriorityQueue<Integer> minQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minQueue = new PriorityQueue<>((a, b) -> (a - b));
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minQueue.add(val);
        if (minQueue.size() > k) {
            minQueue.poll();
        }

        return minQueue.peek();
    }
}
