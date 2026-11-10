class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Time: O(n)
        // Space: O(1)
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int num : nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for(int num : nums) {
            int frequency = freqCount.get(num);
            if(frequency > 1) {
                result += frequency - 1;
                freqCount.put(num, frequency - 1);
            }
        }

        return result;
    }
}