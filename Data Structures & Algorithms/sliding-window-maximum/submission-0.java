class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length + 1 - k];

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

        for(int i = 0; i < k && i < nums.length; i++) {
            sortedMap.put(nums[i], sortedMap.getOrDefault(nums[i], 0) + 1);
        }

        int left = 0;
        int right = k;

        while(right < nums.length) {
            result[left] = sortedMap.lastKey();
            sortedMap.put(nums[left], sortedMap.get(nums[left]) -1);
            if(sortedMap.get(nums[left]) == 0) {
                sortedMap.remove(nums[left]);
            }

            sortedMap.put(nums[right], sortedMap.getOrDefault(nums[right], 0) + 1);
            left++;
            right++;
        }
        result[left] = sortedMap.lastKey();

        return result;
    }
}
