class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int left = 0;
        int right = heights.length-1;;

        while(left < right) {
            int area = (right-left) * Math.min(heights[left], heights[right]);
            result = Math.max(result, area);

            if(heights[left] == heights[right]) {
                left++;
                right--;
            } else if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
