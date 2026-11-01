class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        // Time: O(n*m)
        // Space: O(1)
        int result = 0;

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                result ^= (nums1[i] ^ nums2[j]);
            }
        }

        return result;
    }
}
