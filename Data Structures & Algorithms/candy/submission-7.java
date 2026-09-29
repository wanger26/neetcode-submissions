class Solution {
    public int candy(int[] ratings) {
        
        // Time: O(n)
        // Space: O(1)
        int totalCandies = 1;
        int upStreak = 0;
        int downStreak = 0;
        int peak = 0;

        for(int i=1; i < ratings.length; i++) {
            // Walking up hill
            if(ratings[i-1] < ratings[i]) {
                upStreak++;
                downStreak = 0;
                peak = upStreak;
                totalCandies += 1 + upStreak;
            } else if (ratings[i-1] == ratings[i]) {
                downStreak = 0;
                upStreak = 0;
                peak = 0;
                totalCandies++;
            } else {
                downStreak++;
                upStreak = 0;
                totalCandies += downStreak;

                // If the downhill sequence is longer than the peak we came from,
                // the peak itself needs an extra candy to stay strictly greater 
                // than its left and right neighbors
                if(downStreak > peak) {
                    totalCandies++;
                }
            }
        }

        return totalCandies;
    }
}