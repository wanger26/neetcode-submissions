class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int bestLeft = values[0];

        for(int i = 1; i < values.length; i++) {
            result = Math.max(result, bestLeft + values[i] - i);
            bestLeft = Math.max(bestLeft, values[i] + i);
        }

        return result;
    }
}
