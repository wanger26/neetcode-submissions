class Solution {

    public int jump(int[] nums) {

        int numberOfJumps = 0;
        int currentEnd = 0;
        int maxReachedIndex = 0;
        
        for(int i=0; i < nums.length - 1; i++) {

            maxReachedIndex = Math.max(maxReachedIndex, i + nums[i]);
            if(i == currentEnd) {
                numberOfJumps++;
                currentEnd = maxReachedIndex;
            }
        }

        return numberOfJumps;
    }
}
