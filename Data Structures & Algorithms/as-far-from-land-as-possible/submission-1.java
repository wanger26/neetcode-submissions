class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int result = -1;
        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int initalSize = queue.size();
            for (int k = 0; k < initalSize; k++) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];
                if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 0) {
                    visited[i+1][j] = true;
                    queue.add(new int[] {i + 1, j});
                }

                if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 0) {
                    visited[i-1][j] = true;
                    queue.add(new int[] {i - 1, j});
                }

                if (j + 1 < m && !visited[i][j+1] && grid[i][j+1] == 0) {
                    visited[i][j+1] = true;
                    queue.add(new int[] {i, j+1});
                }

                if (j - 1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 0) {
                    visited[i][j-1] = true;
                    queue.add(new int[] {i, j-1});
                }
            }

            if(!queue.isEmpty()) {
                result = result == -1 ? 1 : result + 1;
            }
        }

        return result;
    }
}
