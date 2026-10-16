class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // Time: O(n^2)
        // Space: O(n^2)
        return dp(nums1, nums2, 0, 0, new Integer[nums1.length][nums2.length]);
    }

    private int dp(int[] nums1, int[] nums2, int index1, int index2, Integer[][] memo) {
        if(index1 == nums1.length || index2 == nums2.length) {
            return 0;
        } else if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }

        int result = 0;
        if(nums1[index1] == nums2[index2]) {
            result = 1 + dp(nums1, nums2, index1+1, index2+1, memo);
        } else {
            result = Math.max(dp(nums1, nums2, index1+1, index2, memo), dp(nums1, nums2, index1, index2+1, memo));
        }

        memo[index1][index2] = result;

        return result;
    }
}
