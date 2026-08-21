
// Time: O(mn)
// Space: O(m)
class Solution {

    // Top Down Approach
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1); // when the total is 0, we found 1 answer
        for(int i=0; i < n; i++) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> tuple : dp.entrySet()) {
                int total = tuple.getKey();
                int count = tuple.getValue();

                // Add
                nextDp.put(total + nums[i], nextDp.getOrDefault(total + nums[i], 0) + count);

                // Subtract
                nextDp.put(total - nums[i], nextDp.getOrDefault(total - nums[i], 0) + count);
            }

            dp = nextDp;
        }

        return dp.getOrDefault(target, 0);
    }

}
