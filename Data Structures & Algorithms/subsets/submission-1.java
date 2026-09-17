class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // Time: O(n*2^n)
        // Space: O(n) 
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int index, List<Integer> currentPath, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // Option 1: Do no select current
        subsets(nums, index + 1, currentPath, result);

        // Option 2: Select current
        currentPath.add(nums[index]);
        subsets(nums, index + 1, currentPath, result);
        currentPath.removeLast();
    }
}
