class Solution {

    // Time: O(n)
    // Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsToIndex = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            numsToIndex.putIfAbsent(nums[i], new ArrayList<>());
            numsToIndex.get(nums[i]).add(i);
        }


        for(int i=0 ; i < nums.length; i++) {
            int needNumber = target - nums[i];
            if(numsToIndex.containsKey(needNumber) && (numsToIndex.get(needNumber).get(0) != i || numsToIndex.get(needNumber).size() > 1)) {
                int secondIndex = numsToIndex.get(needNumber).get(0) != i ? numsToIndex.get(needNumber).get(0) : numsToIndex.get(needNumber).get(1);
                return new int[]{i, secondIndex};
            }
        }

        return null;
    }
}
