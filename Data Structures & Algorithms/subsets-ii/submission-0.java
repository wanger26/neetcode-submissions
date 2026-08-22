class Solution {

    // Top Down
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(dp(nums, new ArrayList<>(), 0));
    }

    private Set<List<Integer>> dp(int[] nums, List<Integer> current, int index) {
        if (index == nums.length) {
            return Set.of(new ArrayList<>(current));
        }

        // Option 1: Include
        int insertionIndex = current.size();
        current.add(nums[index]);
        Set<List<Integer>> result = new HashSet<>(dp(nums, current, index + 1));
        current.remove(insertionIndex);

        // Option 2: Do not include
        result.addAll(dp(nums, current, index + 1));

        return result;
    }
}
