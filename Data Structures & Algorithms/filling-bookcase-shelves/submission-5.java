class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // Time: O(n^2)
        // Space: O(n)
        int[] dp = new int[books.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[books.length] = 0;

        for(int i = books.length - 1; i >= 0; i--) {
            int widthRemaining = shelfWidth;
            int shelfHeight = 0;
            for(int j = i; j < books.length && widthRemaining >= books[j][0]; j++) {
                widthRemaining -= books[j][0];

                shelfHeight = Math.max(shelfHeight, books[j][1]);

                dp[i] = Math.min(dp[i], shelfHeight + dp[j+1]);
            }
        }

        return dp[0];
    }
}
