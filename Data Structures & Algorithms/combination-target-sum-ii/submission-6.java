class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Time: O(2^n)
        // Space: O(n)
        this.result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        while(index < candidates.length && candidates[index] <= target) {
            // Option 1: Choose Num
            current.add(candidates[index]);
            backtrack(candidates, target - candidates[index], index + 1, current);
            current.removeLast();

            while(index + 1< candidates.length && candidates[index] == candidates[index+1]) {
                index++;
            }

            index++;
        }
    }
}
