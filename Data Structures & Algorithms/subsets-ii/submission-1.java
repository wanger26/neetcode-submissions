// Time: O(2^n)
// Space: O(2^n)
class Solution {

    // Top Down
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(recurse(nums, new ArrayList<>(), 0));
    }

    private Set<List<Integer>> recurse(int[] nums, List<Integer> current, int index) {
        if (index == nums.length) {
            return Set.of(new ArrayList<>(current));
        }

        // Option 1: Include
        int insertionIndex = current.size();
        current.add(nums[index]);
        Set<List<Integer>> result = new HashSet<>(recurse(nums, current, index + 1));
        current.remove(insertionIndex);

        // Option 2: Do not include
        result.addAll(recurse(nums, current, index + 1));

        return result;
    }
}
