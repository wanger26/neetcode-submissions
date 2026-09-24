class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int totalSum = 0;

        int currentMaxSum = 0;
        int globalMaxSum = nums[0];

        int currentMinSum = 0;
        int globalMinSum = nums[0];

        for(int num : nums) {

            currentMaxSum = Math.max(num, currentMaxSum + num);
            globalMaxSum = Math.max(globalMaxSum, currentMaxSum);

            currentMinSum = Math.min(num, currentMinSum + num);
            globalMinSum = Math.min(globalMinSum, currentMinSum);

            totalSum += num;
        }

        // In case of all negative, need to return largest negative
        if(globalMaxSum < 0) {
            return globalMaxSum;
        }

        // Return standard max sum and wrapped around max sum
        return Math.max(globalMaxSum, totalSum - globalMinSum);
        
    }
}