class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Time: O(n + nlogk)
        // Space: O(n)
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));
        for(int num : freq.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;

    }
}
