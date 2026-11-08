class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        // Time: O(n^2)
        // Time: O(1)
        int result = 0;
        for(int i = 0; i < values.length; i++) {
            for(int j = i + 1; j < values.length; j++) {
                result = Math.max(result, values[i]+values[j] - (j - i));
            }
        }

        return result;
    }
}
