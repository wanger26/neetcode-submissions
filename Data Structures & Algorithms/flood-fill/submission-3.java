class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Time: O(m*n)
        // Time: O(m*n)
        int originalColor = image[sr][sc];

        if(originalColor != color) {
            dfs(image, sr, sc, color, originalColor);
        }

        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int originalColor) {
        if(i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != originalColor) {
            return;
        }

        image[i][j] = color;

        dfs(image, i-1, j, color, originalColor);
        dfs(image, i+1, j, color, originalColor);
        dfs(image, i, j-1, color, originalColor);
        dfs(image, i, j+1, color, originalColor);
    }
}