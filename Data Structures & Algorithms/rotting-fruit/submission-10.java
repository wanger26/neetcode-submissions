class Solution {
    public int orangesRotting(int[][] grid) {
        int numberOfFreshFruits = 0;
        int numberOfFruitsRotten = 0;

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        boolean anyFruits = false;
        // Add all the rotten fruits
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    numberOfFreshFruits++;
                }
            }
        }

        int result = 0;
        // BFS
        while (!queue.isEmpty()) {
            int originalSize = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < originalSize; i++) {
                int[] coordinates = queue.poll();
                int x = coordinates[0];
                int y = coordinates[1];

                if (grid[x][y] == 1) {
                    numberOfFruitsRotten++;
                    rottedThisMinute = true;
                }

                // Add left if valid
                if (isValid(grid, x - 1, y, seen)) {
                    seen[x - 1][y] = true;
                    queue.add(new int[] {x - 1, y});
                }

                // Add right if valid
                if (isValid(grid, x + 1, y, seen)) {
                    seen[x + 1][y] = true;
                    queue.add(new int[] {x + 1, y});
                }

                // Add top if valid
                if (isValid(grid, x, y - 1, seen)) {
                    seen[x][y - 1] = true;
                    queue.add(new int[] {x, y - 1});
                }

                // Add bottom if valid
                if (isValid(grid, x, y + 1, seen)) {
                    seen[x][y + 1] = true;
                    queue.add(new int[] {x, y + 1});
                }
            }

            if (rottedThisMinute) {
                result++;
            }
        }

        return numberOfFreshFruits == numberOfFruitsRotten ? result : -1;
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] seen) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || seen[x][y]
            || grid[x][y] != 1) {
            return false;
        }

        return true;
    }
}
