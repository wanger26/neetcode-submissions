class Solution {

    // Time: O(nlogK)
    // Space: O(n)

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> valueToFrequency = new HashMap<>();

        for(int num : nums) {
            valueToFrequency.put(num, valueToFrequency.getOrDefault(num, 0) + 1);
        }


        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a,b) -> valueToFrequency.get(a) - valueToFrequency.get(b));
        for(int num : valueToFrequency.keySet()) {
            minQueue.add(num);

            if(minQueue.size() > k) {
                minQueue.poll();
            }
        }

        int[] result = new int[k];

        for(int i=0; i < k; i++) {
            result[i] = minQueue.poll();
        }

        return result;
        
    }
}
