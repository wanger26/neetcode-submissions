class Solution {
    public int shortestBridge(int[][] grid) {

        // Time: O(n*n)
        // Space: O(n*n)
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean foundIslandOne = false;
        boolean[][] firstIsland = new boolean[n][n];
        for (int i = 0; i < n && !foundIslandOne; i++) {
            for (int j = 0; j < n && !foundIslandOne; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, firstIsland, queue);
                    foundIslandOne = true;
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int initalSize = queue.size();
            for (int i = 0; i < initalSize; i++) {
                int[] node = queue.poll();
                int y = node[0];
                int x = node[1];

                firstIsland[y][x] = true;

                if (isValid(y - 1, x, n) && !firstIsland[y - 1][x]) {
                    if (grid[y - 1][x] == 1) {
                        return result;
                    }

                    queue.add(new int[] {y - 1, x});
                    firstIsland[y-1][x] = true;
                }

                if (isValid(y + 1, x, n) && !firstIsland[y + 1][x]) {
                    if (grid[y + 1][x] == 1) {
                        return result;
                    }
                    queue.add(new int[] {y + 1, x});
                    firstIsland[y + 1][x] = true;
                }

                if (isValid(y, x - 1, n) && !firstIsland[y][x - 1]) {
                    if (grid[y][x - 1] == 1) {
                        return result;
                    }
                    queue.add(new int[] {y, x - 1});
                    firstIsland[y][x - 1] = true;
                }

                if (isValid(y, x + 1, n) && !firstIsland[y][x + 1]) {
                    if (grid[y][x + 1] == 1) {
                        return result;
                    }
                    queue.add(new int[] {y, x + 1});
                    firstIsland[y][x + 1] = true;
                }
            }
            result++;
        }

        return -1;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] seen, Queue<int[]> queue) {
        if (!isValid(i, j, grid.length) || seen[i][j] || grid[i][j] != 1) {
            return;
        }

        seen[i][j] = true;
        queue.add(new int[] {i, j});
        dfs(grid, i - 1, j, seen, queue);
        dfs(grid, i + 1, j, seen, queue);
        dfs(grid, i, j - 1, seen, queue);
        dfs(grid, i, j + 1, seen, queue);
    }

    private boolean isValid(int i, int j, int n) {
        return !(i < 0 || j < 0 || i == n || j == n);
    }
}