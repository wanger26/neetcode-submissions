class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Time: O(n+m)
        // Space: O(n+m)
        int[] result = new int[m+n];
        int index1 = 0;
        int index2 = 0;

        for(int i=0; i < result.length; i++) {
            if(index1 < m && index2 < n) {
                if(nums1[index1] < nums2[index2]) {
                    result[i] = nums1[index1++];
                } else {
                    result[i] = nums2[index2++];
                }
            } else if (index1 < m) {
                result[i] = nums1[index1++];
            } else {
                result[i] = nums2[index2++];
            }
        }


        for(int i=0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }
}