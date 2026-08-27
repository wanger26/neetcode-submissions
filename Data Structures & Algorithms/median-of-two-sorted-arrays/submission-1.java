class Solution {

    // Time: O(log(min(m,n)))
    // Space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        int totalLength = nums1.length + nums2.length;
        int medianIndex = (totalLength+1) /2;
        
        while (left <= right) {
            int nums1Parition = (left + right) / 2;
            int nums2Partion = medianIndex - nums1Parition;

            int nums1Left = nums1Parition > 0 ? nums1[nums1Parition-1] : Integer.MIN_VALUE;
            int nums1Right = nums1Parition < nums1.length ? nums1[nums1Parition] : Integer.MAX_VALUE;

            int nums2Left = nums2Partion > 0 ? nums2[nums2Partion-1] : Integer.MIN_VALUE;
            int nums2Right = nums2Partion < nums2.length ? nums2[nums2Partion] : Integer.MAX_VALUE;

            if(nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // We found a valid partition
                if(totalLength % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right))/2.0;
                }
                return Math.max(nums1Left, nums2Left);
            } else if (nums1Left > nums2Right){
                // Need to go left
                right = nums1Parition - 1;
            } else {
                // Need to go right
                left = nums1Parition + 1;
            }
        }

        return -1;
        
    }
}
