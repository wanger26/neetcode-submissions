class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return dp(books, shelfWidth, 0, new int[books.length]);
    }

    private int dp(int[][] books, int shelfWidth, int index, int[] memo) {
        if(books.length == index) {
            return 0;
        } else if(memo[index] != 0) {
            return memo[index];
        }

        int shelfWidthLeft = shelfWidth - books[index][0];
        int shelfHeight = books[index][1];
        int result = Integer.MAX_VALUE;
        for(int i = index + 1; i < books.length && shelfWidthLeft >= books[i][0]; i++) {
            shelfWidthLeft -= books[i][0];

            // Option 1: Place book in next shelf
            int heightWhenPlacingNextShelf = shelfHeight + dp(books, shelfWidth, i, memo);

            // Option 2: Place book in current shelf
            shelfHeight = Math.max(shelfHeight, books[i][1]);
            int heightWhenPlacingOnShelf = shelfHeight + dp(books, shelfWidth, i+1, memo);

            result = Math.min(heightWhenPlacingNextShelf, heightWhenPlacingOnShelf);
        }

        if(result == Integer.MAX_VALUE) {
            result = shelfHeight + dp(books, shelfWidth, index+1, memo);
        }

        memo[index] = result;

        return result;
    }
}
