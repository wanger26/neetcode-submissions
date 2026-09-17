class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Time: O(n*2^n)
        // Space: O(n) 

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
    }
}
