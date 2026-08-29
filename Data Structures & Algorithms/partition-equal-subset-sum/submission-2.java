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

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        
        for(int i=nums.length-1; i >= 0; i--) {
            Set<Integer> newDp = new HashSet<>();
            for(int currentSum : dp) {
                int newSum = currentSum + nums[i];
                if(newSum == partitionSum) {
                    return true;
                }
                newDp.add(newSum);
                newDp.add(currentSum);
            }
            dp = newDp;
        }

        return false;
        
    }
}
