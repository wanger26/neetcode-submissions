class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int bestLeft = values[0];

        for(int i = 1; i < values.length; i++) {
            bestLeft--;
            bestLeft = Math.max(bestLeft, values[i-1] - 1);
            result = Math.max(result, bestLeft + values[i]);
        }

        return result;
    }
}
