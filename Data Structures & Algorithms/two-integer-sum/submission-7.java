class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Time: O(n)
        // Space: O(n)
        Map<Integer, Integer> numbersSeen = new HashMap<>();
        int[] result = new int[2];
        for(int i = nums.length - 1; i >= 0; i--) {
            int needed = target - nums[i];
            if(numbersSeen.containsKey(needed)) {
                result[0] = i;
                result[1] = numbersSeen.get(needed);
            }
            numbersSeen.put(nums[i], i);
        }

        return result;
    }
}
