class Solution {
    public int specialArray(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        int n = nums.length;
        int[] frequencies = new int[n + 1];

        for (int num : nums) {
            frequencies[Math.min(num, n)]++;
        }

        int count = 0;
        for (int x = n; x >= 1; x--) {
            count += frequencies[x];
            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}