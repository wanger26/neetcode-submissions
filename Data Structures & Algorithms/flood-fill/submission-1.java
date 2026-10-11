class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        if(color == image[sr][sc]) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int originalColor = image[sr][sc];
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int i = coordinates[0];
            int j = coordinates[1];

            image[i][j] = color;

            if(i+1 < n && image[i+1][j] == originalColor) {
                queue.add(new int[]{i+1,j});
            }

            if(i-1 >= 0 && image[i-1][j] == originalColor) {
                queue.add(new int[]{i-1,j});
            }

            if(j+1 < m && image[i][j+1] == originalColor) {
                queue.add(new int[]{i,j+1});
            }

            if(j-1 >= 0 && image[i][j-1] == originalColor) {
                queue.add(new int[]{i,j-1});
            }
        }

        return image;
    }
}