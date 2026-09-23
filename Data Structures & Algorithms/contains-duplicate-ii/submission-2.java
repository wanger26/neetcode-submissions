class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int left = 0;
        int right = k;
        Set<Integer> slidingWindowValues = new HashSet<>();
        for(int i = 0; i < k && i < nums.length; i++) {
            if(!slidingWindowValues.add(nums[i])) {
                return true;
            }
        }

        while (right < nums.length) {
            if(!slidingWindowValues.add(nums[right])) {
                return true;
            }

            slidingWindowValues.remove(nums[left]);
            left++;
            right++;
        }
        
        return false;
    }
}