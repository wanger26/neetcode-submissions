class Solution {
    public int splitArray(int[] nums, int k) {

        // Time: O(n * log(m + s)) where m is the max value in nums and s is the sum of all numbers in nums
        // Space: O(1)

        int maxNum = 0;
        int sum = 0;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }

        int left = maxNum;
        int right = sum;

        int result = 0;
        while(left <= right) {
            int pivot = (left+right)/2;

            boolean isValidTarget = canSplitArray(nums, k, pivot);
            if(isValidTarget) {
                // Go left bec we need to try smaller target
                result = pivot;
                right = pivot - 1;
            } else {
                // Go right bec we need to try bigger target
                left = pivot + 1;
            }
        }

        return result;
        
    }

    private boolean canSplitArray(int[] nums, int k, int targetSum) {
        int currentSum = 0;
        for(int num : nums) {
            currentSum += num;

            if(currentSum > targetSum) {
                k--;
                currentSum = num;
            }

            if(k == 0) {
                return false;
            }
        }

        return true;
    }
}