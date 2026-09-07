class Solution {

    // Time: O(n)
    // Space: O(1)
    public int trap(int[] height) {
        if(height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length-1;

        int leftMaxHeight = height[left];
        int rightMaxHeight = height[right];

        int result = 0;

        while(left < right) {

            // If left is shorter than right. Right wall cant help us as we are limtited by left
            if(leftMaxHeight < rightMaxHeight) {
                // Increase left pointer so we can do the water capture calc
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, height[left]);
                result += leftMaxHeight - height[left];
            } else {
                right--;
                rightMaxHeight = Math.max(rightMaxHeight, height[right]);
                result += rightMaxHeight - height[right];
            }
        }

        return result;
    }
}
