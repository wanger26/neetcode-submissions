class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        // Time: O(n*m)
        // Space: O(m)
        int n = nums1.length;
        int m = nums2.length;
        int[] dp = new int[m+1];
        
        int index1 = 0;
        int index2 = 0;
        for(int i=n - 1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            for (int j= m - 1; j >=0; j--) {
                if(nums1[i] == nums2[j]) {
                    newDp[j] = 1 + dp[j+1];
                } else {
                    newDp[j] = Math.max(dp[j], newDp[j+1]);
                }
            }
            dp = newDp;
        }

        return dp[0];
    }
}
