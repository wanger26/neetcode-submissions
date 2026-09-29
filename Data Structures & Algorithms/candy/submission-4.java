class Solution {
    public int candy(int[] ratings) {

        // Time: O(n)
        // Space: O(n)

        int n = ratings.length;

        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            populateCandies(ratings, i, candies);
        }

        int result = 0;
        for(int numOfCandies : candies) {
            result += numOfCandies;
        }

        return result;
    }

    public int populateCandies(int[] ratings, int index, int[] candies) {
        if(candies[index] != 0) {
            return candies[index];
        }

        int result = 1;
        if(index - 1 >= 0 && ratings[index] > ratings[index - 1]) {
            result = 1 + populateCandies(ratings, index - 1, candies); 
        }

        if(index + 1 < ratings.length && ratings[index] > ratings[index + 1]) {
            result = Math.max(result, 1 + populateCandies(ratings, index + 1, candies));
        }

        candies[index] = result;

        return result;
    }
}