class Solution {
    public int[] findErrorNums(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        int[] result = new int[2];
        int[] freqCount = new int[nums.length+1];

        for(int i=0; i < nums.length; i++) {
            freqCount[nums[i]]++;
        }

        for(int i = 1; i < freqCount.length; i++) {
            if(freqCount[i] == 2) {
                result[0] = i;
            } else if (freqCount[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}