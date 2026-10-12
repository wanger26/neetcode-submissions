class Solution {
    public int countOdds(int low, int high) {
        if(low % 2 == 0) {
            low++;
        }

        return (high-low+2)/2;
    }
}