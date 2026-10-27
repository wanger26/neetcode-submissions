class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Time: O(1)
        // Space: O(1)
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
