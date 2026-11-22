class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        permutate(nums, new LinkedHashSet<>());

        return this.result;
    }

    private void permutate(int[] nums, LinkedHashSet<Integer> currentPath) {
        if(currentPath.size() == nums.length) {
            this.result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int num : nums) {
            if(currentPath.contains(num)) {
                continue;
            }

            currentPath.add(num);
            permutate(nums, currentPath);
            currentPath.remove(num);
        }
    }
}
