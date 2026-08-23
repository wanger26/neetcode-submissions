class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            // If we saw the value we need. Done.
            if(valueIndexMap.containsKey(diff)) {
                return new int[]{valueIndexMap.get(diff), i};
            }
            valueIndexMap.put(nums[i], i);
        }

        return null;
    }
}
