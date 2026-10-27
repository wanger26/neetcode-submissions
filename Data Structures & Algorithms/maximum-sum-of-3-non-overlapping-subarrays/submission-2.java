class Solution {
    private static final int NEG_INF = Integer.MIN_VALUE / 4;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Calculate the sum of every window of length k.
        int[] kSum = new int[n - k + 1];
        int windowSum = 0;

        for (int i = 0; i < n; i++) {
            windowSum += nums[i];

            if (i >= k) {
                windowSum -= nums[i - k];
            }

            if (i >= k - 1) {
                kSum[i - k + 1] = windowSum;
            }
        }

        // dp[index][selected] = maximum sum obtainable
        // starting at index after selecting 'selected' windows.
        int[][] dp = new int[n + 1][4];

        for (int index = n; index >= 0; index--) {
            dp[index][3] = 0;

            for (int selected = 2; selected >= 0; selected--) {
                int remaining = 3 - selected;

                // Not enough space for all remaining windows.
                if (index + remaining * k > n) {
                    dp[index][selected] = NEG_INF;
                    continue;
                }

                // Option 1: Include the current window.
                int include = kSum[index]
                    + dp[index + k][selected + 1];

                // Option 2: Skip the current window.
                int skip = dp[index + 1][selected];

                dp[index][selected] = Math.max(include, skip);
            }
        }

        // Reconstruct the three starting indices.
        int[] result = new int[3];
        int index = 0;
        int selected = 0;

        while (selected < 3) {
            int include = kSum[index]
                + dp[index + k][selected + 1];

            int skip = dp[index + 1][selected];

            if (include >= skip) {
                result[selected] = index;
                selected++;
                index += k;
            } else {
                index++;
            }
        }

        return result;
    }
}