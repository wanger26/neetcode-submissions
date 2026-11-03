class Solution {
    public int maxArea(int[] heights) {

        // Time: O(n)
        // Space: O(1)
        int left = 0;
        int right = heights.length - 1;

        int result = 0;
        while(left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            result = Math.max(result, Math.min(leftHeight, rightHeight) * (right-left));

            if(leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
