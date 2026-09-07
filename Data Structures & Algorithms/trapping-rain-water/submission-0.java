class Solution {
    public int trap(int[] height) {
        Stack<Integer> indexCandidates = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            // If we can potentially trap water --> right wall is greater than or equal to prev
            while (!indexCandidates.isEmpty() && height[indexCandidates.peek()] <= height[i]) {
                int baseHeight = height[indexCandidates.pop()];
                int rightWallHeight = height[i];

                // If a left wall exists. We can trap water between left and right wall
                if (!indexCandidates.isEmpty()) {
                    int leftWallHeight = height[indexCandidates.peek()];
                    int heightOfWater = Math.min(leftWallHeight, rightWallHeight) - baseHeight;
                    int widthOfWater = i - indexCandidates.peek() - 1;
                    result += heightOfWater * widthOfWater;
                }
            }
            indexCandidates.push(i);
        }

        return result;
    }
}
