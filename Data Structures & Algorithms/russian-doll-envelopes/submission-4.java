class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Time: O(n^2)
        // Space: O(n)

        int n = envelopes.length;

        Arrays.sort(envelopes, (a,b) -> {
            int result = Integer.compare(a[0], b[0]);
            if(result != 0) {
                return result;
            }

            return Integer.compare(a[1], b[1]);
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 0;
        for(int outer = 0; outer < n; outer++) {
            int outerWidth = envelopes[outer][0];
            int outerHeight = envelopes[outer][1];
            for(int inner = 0; inner < n; inner++) {
                int innerWidth = envelopes[inner][0];
                int innerHeight = envelopes[inner][1];

                if(innerWidth < outerWidth && innerHeight < outerHeight) {
                    dp[outer] = Math.max(dp[outer], dp[inner] + 1);
                }
            }

            result = Math.max(result, dp[outer]);
        }

        return result;
    }
}