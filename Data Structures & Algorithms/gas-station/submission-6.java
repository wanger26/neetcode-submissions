class Solution {

    // Time: O(n)
    // Space: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum = 0;
        for(int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
        }

        if (totalSum < 0) {
            return -1;
        }

        int runningCost = 0;
        int result = 0;
        for(int i = 0; i < gas.length; i++) {
            runningCost += gas[i] - cost[i];
            if (runningCost < 0) {
                runningCost = 0;
                result = i+1;
            }
        }

        return result;
    }
}
