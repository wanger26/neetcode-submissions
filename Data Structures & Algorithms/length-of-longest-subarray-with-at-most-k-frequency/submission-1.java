class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        // Time: O(n)
        // Space: O(n)

        if(nums.length < k) {
            return nums.length;
        }

        Map<Integer, Integer> window = new HashMap<>();
        int left = 0;

        int result = 0;
        for(int right = 0; right < nums.length; right++) {
            int num = nums[right];
            window.put(num, window.getOrDefault(num, 0) + 1);

            while(window.get(num) > k) {
                int newFreq = window.get(nums[left]) - 1;

                if(newFreq == 0) {
                    window.remove(nums[left]);
                } else {
                    window.put(nums[left], newFreq);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
