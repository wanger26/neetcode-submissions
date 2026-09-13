class Solution {
    public int minCostClimbingStairs(int[] cost) {

        // Time: O(n)
        // Space: O(1)
        int previousStep = 0;
        int previousPreviousStep = 0;

        for(int i=cost.length-1; i >= 0; i--) {
            int minCost = cost[i] + Math.min(previousStep, previousPreviousStep);
            previousPreviousStep = previousStep;
            previousStep = minCost;
        }

        return Math.min(previousStep, previousPreviousStep);
    }
}
