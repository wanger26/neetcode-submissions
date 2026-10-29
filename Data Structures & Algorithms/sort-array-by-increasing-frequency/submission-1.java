class Solution {
    public int[] frequencySort(int[] nums) {

        // Time: O(nlogn)
        // Space: O(n)
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for(int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minQueue = new PriorityQueue<>((a,b) -> {
            int result = a.getValue() - b.getValue();
            if(result == 0) {
                return b.getKey() - a.getKey();
            }
            return result;
        });
        for(Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            minQueue.add(entry);
        }

        int index = 0;
        int[] result = new int[nums.length];
        while(!minQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minQueue.poll();
            int number = entry.getKey();
            int freqeuncy = entry.getValue();
            for(int i = 0; i < freqeuncy; i++) {
                result[index] = number;
                index++;
            }
        }

        return result;
    }
}