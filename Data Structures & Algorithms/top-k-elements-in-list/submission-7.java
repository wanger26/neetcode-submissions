class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Time: O(n)
        // Space: O(n)
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length];
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            int frequencyIndex = frequency - 1;

            if(buckets[frequencyIndex] == null) {
                buckets[frequencyIndex] = new ArrayList<>();
            }

            buckets[frequencyIndex].add(number);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if(buckets[i] == null) {
                continue;
            }

            int numOfIterations = Math.min(buckets[i].size(), k - index);
            for(int j = 0; j < numOfIterations; j++) {
                result[index++] = buckets[i].get(j);
            }
        }

        return result;

    }
}
