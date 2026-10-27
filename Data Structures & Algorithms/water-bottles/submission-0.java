class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        // Time: O(n) where n is the number of bottles
        // Space: O(1)

        int result = 0;
        int fullBottles = numBottles;
        int emptyBottles = 0;

        while(fullBottles != 0) {
            result += fullBottles;
            
            emptyBottles += fullBottles;
            fullBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return result;
    }
}
