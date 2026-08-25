class Solution {

    // Time: O(n)
    // Space: O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1; // Start at prev answer

            // While the temps at j is less than or equal to the current i, we can keep jumping
            // until we see a bigger temperature OR we hit the end of the array
            while (j < n && temperatures[j] <= temperatures[i]) {
                // Special case. We already hit end of the road. No need to go further
                if (result[j] == 0) { 
                    j = n;
                } else {
                    j += result[j]; // Jump to the next higher temp
                }
            }

            // If we did not get to the end, lets set the answer
            if(j < n) {
                result[i] = j-i;
            }
        }

        return result;
    }
}
