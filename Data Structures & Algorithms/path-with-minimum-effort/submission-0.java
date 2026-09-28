class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] differences = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j=0; j < m; j++) {
                differences[i][j] = Integer.MAX_VALUE;
            }
        }
        differences[0][0] = 0;

        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minQueue.add(new int[]{0, 0, 0}); // {diff, row, col}


        while(!minQueue.isEmpty()) {
            int[] current = minQueue.poll();

            int difference = current[0];
            int row = current[1];
            int col = current[2];

            if(row == n - 1 && col == m - 1) {
                return difference;
            }

            if(differences[row][col] < difference) {
                continue;
            }

            if(row - 1 >= 0) {
                addToQueue(heights, minQueue, row, col, row - 1, col , difference, differences);
            }

            if(row + 1 < n) {
                addToQueue(heights, minQueue, row, col, row + 1, col , difference, differences);
            }

            if(col - 1 >= 0) {
                addToQueue(heights, minQueue, row, col, row, col - 1 , difference, differences);
            }

            if(col + 1 < m) {
                addToQueue(heights, minQueue, row, col, row, col + 1 , difference, differences);
            }
        }

        return 0;
    }

    private void addToQueue(int[][] heights, PriorityQueue<int[]> minQueue, int row, int col, int nextRow, int nextCol, int difference, int[][] differences) {
        int newDifference = Math.max(difference, Math.abs(heights[row][col] - heights[nextRow][nextCol]));

        if(newDifference < differences[nextRow][nextCol]) {
            differences[nextRow][nextCol] = newDifference;
            minQueue.add(new int[]{newDifference, nextRow, nextCol});
        }
    }
}