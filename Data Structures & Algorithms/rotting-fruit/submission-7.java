class Solution {

    private int numberOfFreshFruits = 0;
    private int numberOfFruitsRotten = 0;

    public int orangesRotting(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        boolean anyFruits = false;
        // Add all the rotten fruits
        for(int i=0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    this.numberOfFreshFruits++;
                }
            }
        }

        // For all rotten fruits begin rotting neighbors
        int result = bfs(grid, queue, seen);
        return numberOfFreshFruits == numberOfFruitsRotten ? result : -1;
    }

    private int bfs(int[][] grid, Queue<int[]> queue, boolean[][] seen) {

        // If the queue
        if (queue.isEmpty()) {
            return 0;
        }

        int originalSize = queue.size();
        boolean anyChanges = false;
        for(int i = 0; i < originalSize; i++) {
            int[] coordinates = queue.poll();
            int x = coordinates[0];
            int y = coordinates[1];

            if(seen[x][y]) {
                continue;
            }

            // Mark seen and rotten
            seen[x][y] = true;

            if(grid[x][y] == 1) {
                numberOfFruitsRotten++;
                anyChanges = true;
            }

            // Add left if valid
            if(isValid(grid, x-1, y, seen)) {
                queue.add(new int[]{x-1, y});
            }

            // Add right if valid
            if(isValid(grid, x+1, y, seen)) {
                queue.add(new int[]{x+1, y});
            }

            // Add top if valid
            if(isValid(grid, x, y-1, seen)) {
                queue.add(new int[]{x, y-1});
            }

            // Add bottom if valid
            if(isValid(grid, x, y+1, seen)) {
                queue.add(new int[]{x, y+1});
            }
        }

        return bfs(grid, queue, seen) + (anyChanges ? 1 : 0);
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] seen) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || seen[x][y] || grid[x][y] != 1) {
            return false;
        }

        return true;
    }
}
