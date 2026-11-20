class Solution {
    public int specialArray(int[] nums) {

        // Time: O(nlogn)
        // Space: O(1)
        int left = 1;
        int right = nums.length;

        while(left <= right) {
            int pivot = (left+right)/2;
            int numGreatOrEqualTo = 0;
            for(int num : nums) {
                if(num >= pivot) {
                    numGreatOrEqualTo++;
                }
            }

            if(pivot == numGreatOrEqualTo) {
                return pivot;
            } else if (pivot < numGreatOrEqualTo) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }
}