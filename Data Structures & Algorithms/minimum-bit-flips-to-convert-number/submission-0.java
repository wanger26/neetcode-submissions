class Solution {
    public int minBitFlips(int start, int goal) {

        int result = 0;
        for(int i = 0; i < 31; i++) {
            int goalBit = goal & 1;
            int startBit = start & 1;
            if(goalBit != startBit) {
                result++;
            }
            goal = (goal >> 1);
            start = (start >> 1);
        }

        return result;

    }
}
