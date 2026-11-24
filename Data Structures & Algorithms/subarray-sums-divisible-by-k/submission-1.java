class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Time: O(n)
        // Space: O(n)
        Map<Integer, Integer> remainderToFreqCount = new HashMap<>();
        remainderToFreqCount.put(0, 1);

        int result = 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            int remainder = sum % k;
            result += remainderToFreqCount.getOrDefault(remainder, 0);
            remainderToFreqCount.put(remainder, remainderToFreqCount.getOrDefault(remainder, 0) + 1);
        }

        return result;
    }
}