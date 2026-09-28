class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        // {effort, row, col}
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minQueue.add(new int[]{0, 0, 0});

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!minQueue.isEmpty()) {
            int[] current = minQueue.poll();
            int difference = current[0];
            int row = current[1];
            int col = current[2];

            // Target reached - since minQueue pops smallest effort first, this is optimal
            if (row == n - 1 && col == m - 1) {
                return difference;
            }

            // Skip processing if we already found a shorter path to this cell
            if (difference > distance[row][col]) {
                continue;
            }

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                    int newDifference = Math.max(difference, Math.abs(heights[row][col] - heights[nextRow][nextCol]));
                    
                    // Relax the edge only if we found a path with lower effort
                    if (newDifference < distance[nextRow][nextCol]) {
                        distance[nextRow][nextCol] = newDifference;
                        minQueue.add(new int[]{newDifference, nextRow, nextCol});
                    }
                }
            }
        }

        return 0;
    }
}