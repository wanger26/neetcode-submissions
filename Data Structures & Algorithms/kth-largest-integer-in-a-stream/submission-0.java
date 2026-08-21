class KthLargest {

    private PriorityQueue<Integer> minQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minQueue = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minQueue.add(val);
        if(minQueue.size() > k) {
            minQueue.poll();
        }

        return minQueue.peek();
    }
}
