class Solution {
    public int minimizeMax(int[] nums, int p) {
        // nums = [10,1,2,7,1,3]
        // [1,1,2,3,7,10]

        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n-1] - nums[0];

        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int numOfPairs = 0;
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i+1] - nums[i] <= mid) {
                    numOfPairs++;
                    i++;
                }
            }

            if(numOfPairs >= p) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}