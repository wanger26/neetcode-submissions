class Solution {
    public int countOdds(int low, int high) {
        // Time: O(1)
        // Space: O(1)
        if(low % 2 == 0) {
            low++;
        }

        return (high-low+2)/2;
    }
}