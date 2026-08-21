class Solution {

    // Top Down Approach
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n+1];
        for(int i=0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }

        dp[0].put(0, 1); // when the total is 0, we found 1 answer
        for(int i=0; i < n; i++) {
            for (Map.Entry<Integer, Integer> tuple : dp[i].entrySet()) {
                int total = tuple.getKey();
                int count = tuple.getValue();

                // Add
                dp[i+1].put(total + nums[i], dp[i+1].getOrDefault(total + nums[i], 0) + count);

                // Subtract
                dp[i+1].put(total - nums[i], dp[i+1].getOrDefault(total - nums[i], 0) + count);
            }
        }

        return dp[n].getOrDefault(target, 0);
    }

}
