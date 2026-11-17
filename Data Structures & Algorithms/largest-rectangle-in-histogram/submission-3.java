class Solution {
    public int largestRectangleArea(int[] heights) {

        // Time: O(n)
        // Space: O(n)
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];

            if (stack.isEmpty() || stack.peek()[1] <= currentHeight) {
                stack.push(new int[] {i, currentHeight});
            } else {
                int index = -1;
                while (!stack.isEmpty() && stack.peek()[1] > currentHeight) {
                    int[] indexHeightPair = stack.pop();
                    index = indexHeightPair[0];
                    int height = indexHeightPair[1];
                    result = Math.max(result, (i - index) * height);
                }

                stack.push(new int[] {index, currentHeight});
            }
        }

        while (!stack.isEmpty()) {
            int[] indexHeightPair = stack.pop();
            int index = indexHeightPair[0];
            int height = indexHeightPair[1];

            result = Math.max(result, (n - index) * height);
        }

        return result;
    }
}
