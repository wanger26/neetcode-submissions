class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] longestIncreasingAtIndex = new int[n];
        for (int i = 0; i < n; i++) {
            longestIncreasingAtIndex[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    longestIncreasingAtIndex[i] = Math.max(longestIncreasingAtIndex[i], longestIncreasingAtIndex[j] + 1);
                }
            }
        }

        int[] longestDecreasingAtIndex = new int[n];
        for (int i = n-1; i >= 0; i--) {
            longestDecreasingAtIndex[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    longestDecreasingAtIndex[i] = Math.max(longestDecreasingAtIndex[i], longestDecreasingAtIndex[j] + 1);
                }
            }
        }

        int result = 0;
        for (int peak = 1; peak < n - 1; peak++) {
            if(longestIncreasingAtIndex[peak] > 1 && longestDecreasingAtIndex[peak] > 1) {
                result = Math.max(result, longestIncreasingAtIndex[peak] + longestDecreasingAtIndex[peak] - 1);
            }
        }

        return n - result;
    }
}
