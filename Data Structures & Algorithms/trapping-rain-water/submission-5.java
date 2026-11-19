class Solution {
    public int trap(int[] height) {

        // Time: O(n)
        // Space: O(n)
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        int currentAmount = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottom = stack.pop();

                if(stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int width = i - left - 1;
                int depth = Math.min(height[i], height[left]) - height[bottom];
                result += width * depth;
            }

            stack.push(i);

        }

        return result;
    }
}
