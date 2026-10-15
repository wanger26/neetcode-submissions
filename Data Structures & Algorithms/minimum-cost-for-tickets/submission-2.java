class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        // Time: O(n)
        // Space: O(n)
        return dfs(days, costs, 0, new int[days.length]);
    }

    private int dfs(int[] days, int[] costs, int index, int[] memo) {
        if(index == days.length) {
            return 0;
        } else if (memo[index] != 0) {
            return memo[index];
        }

        // Option 1: Day Pass
        int result = costs[0] + dfs(days, costs, index+1, memo);

        // Option 2: 7 Day Pass
        int nextIndex = index + 1;
        for(; nextIndex < days.length && days[index] + 7 > days[nextIndex]; nextIndex++) {}
        result = Math.min(result, costs[1] + dfs(days, costs, nextIndex, memo));

        // Option 3: 30 Day Pass
        for(; nextIndex < days.length && days[index] + 30 > days[nextIndex]; nextIndex++) {}
        result = Math.min(result, costs[2] + dfs(days, costs, nextIndex, memo));

        memo[index] = result;
        return result;
    }
}