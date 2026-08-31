class Solution {

    // Time: O(nlogn)
    // Space: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a,b) -> a - b);

        for(int num : nums) {
            minQueue.add(num);
            if(minQueue.size() > k) {
                minQueue.poll();
            }
        }

        return minQueue.peek();
    }
}
