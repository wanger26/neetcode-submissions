class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        // Time: O(nlogn + nlogM) where M is the max value of the array
        // Space: O(logn)

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1];

        while (left < right) {
            int pivot = (left + right) / 2;

            int numberOfPairDiffLessThanOrEqualToPivot = numberOfPairDiffLessThanOrEqualTo(nums, pivot);
            if (numberOfPairDiffLessThanOrEqualToPivot < k) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return left;
    }

    private int numberOfPairDiffLessThanOrEqualTo(int[] nums, int num) {
        int left = 0;
        int result = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > num) {
                left++;
            }

            result += right - left;
        }

        return result;
    }
}
