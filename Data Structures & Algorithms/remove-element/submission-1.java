public class Solution {
    public int removeElement(int[] nums, int val) {
        
        // Time: O(n)
        // Space: O(1)
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return n;
    }
}