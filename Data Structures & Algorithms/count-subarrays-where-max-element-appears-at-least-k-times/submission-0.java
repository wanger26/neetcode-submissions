class Solution {
    public long countSubarrays(int[] nums, int k) {
        // [2,1,2,1,2,1,2]
        // k=2

        int n = nums.length;

        int maxValue = 0;
        int maxValueCount = 0;
        for (int num : nums) {
            if (maxValue < num) {
                maxValue = num;
                maxValueCount = 0;
            }
            maxValueCount++;
        }

        if (maxValueCount < k) {
            return 0;
        }

        int left = 0;
        long result = 0;
        int currentCount = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxValue) {
                currentCount++;
            }

            System.out.println(currentCount);
            while (currentCount == k) {
                result += n - right;

                if (nums[left] == maxValue) {
                    currentCount--;
                }
                left++;
            }
        }

        return result;
    }
}
