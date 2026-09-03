class Solution {
    public int missingNumber(int[] nums) {
        int[] orderedNums = new int[nums.length+1];
        orderedNums[0] = -1;

        for(int num : nums) {
            orderedNums[num] = num;
        }

        for(int i=0; i < orderedNums.length; i++) {
            if(orderedNums[i] != i) {
                return i;
            }
        }
        return -1;
    }
}
