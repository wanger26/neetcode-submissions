class Solution {
    private int EMPTY_CELL = 2147483647;

    // Time: O(m*n)
    // Space: O(m*n)
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (grid[x][y] == 0) {
                    queue.add(new int[] {x, y});
                }
            }
        }

        // Perform BFS
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                int currentX = coordinate[0];
                int currentY = coordinate[1];
                addValidSpotsToQueue(grid, currentX, currentY, queue);
            }
            distance++;
        }
    }

    private void addValidSpotsToQueue(int[][] grid, int x, int y, Queue<int[]> queue) {
        int nextDistance = grid[x][y] + 1;
        if (isValid(grid, x - 1, y)) {
            grid[x-1][y] = nextDistance;
            queue.add(new int[] {x - 1, y});
        }
        if (isValid(grid, x + 1, y)) {
            grid[x+1][y] = nextDistance;
            queue.add(new int[] {x + 1, y});
        }
        if (isValid(grid, x, y - 1)) {
            grid[x][y-1] = nextDistance;
            queue.add(new int[] {x, y - 1});
        }
        if (isValid(grid, x, y + 1)) {
            grid[x][y+1] = nextDistance;
            queue.add(new int[] {x, y + 1});
        }
    }
    private boolean isValid(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 0 && grid[x][y] == EMPTY_CELL;
    }
}
