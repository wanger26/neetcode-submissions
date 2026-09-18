class Solution {
    public int subarraySum(int[] nums, int k) {

        // Time: O(n)
        // Space: O(n)
        int currentSum = 0;
        int result = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for(int num : nums) {
            currentSum += num;
            int sumNeeded = currentSum - k;
            if(prefixSum.containsKey(sumNeeded)) {
                result += prefixSum.get(sumNeeded);
            }
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}