class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false; // Cannot partition if sum is odd
        }
        int partitionSum = sum/2;
        return dp(nums, 0, partitionSum, new HashMap<>());
    }

    private boolean dp(int[] nums, int index, int sum, Map<String, Boolean> memo) {
        String key = index + "-" + sum;
        if (sum == 0) {
            return true;
        } else if(index == nums.length || sum < 0) {
            return false;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        }
        System.out.println(key);

        // Option 1: Use current num
        boolean result = dp(nums, index+1, sum - nums[index], memo);

        // Option 2: Do not use current sum
        result = result || dp(nums, index+1, sum , memo);
        memo.put(key, result);
        return result;
    }
}
