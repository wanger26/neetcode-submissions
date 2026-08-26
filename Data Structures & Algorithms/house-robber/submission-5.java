class Solution {

    // Time: O(n)
    // Space: O(1)
    public int rob(int[] nums) {
        
        int result = 0;
        int maxAtNeighbour = 0;
        int maxAtNeighboursNeighbour = 0;
        for(int i=nums.length-1; i >=0; i--) {
            result = Math.max(nums[i] + maxAtNeighboursNeighbour, maxAtNeighbour);

            int temp = maxAtNeighbour;
            maxAtNeighbour = result;
            maxAtNeighboursNeighbour = temp;
        }

        return result;
    }
}
