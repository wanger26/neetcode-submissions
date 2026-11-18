class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;

        int currentGas = 0;
        int totalGasLeft = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGasLeft += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            if(currentGas < 0) {
                result = i + 1;
                currentGas = 0;
            }
        }

        return totalGasLeft < 0 ? -1 : result;
    }
}
