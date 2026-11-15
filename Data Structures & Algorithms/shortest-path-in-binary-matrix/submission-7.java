class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] != 0) {
            return -1;
        }

        int n = grid.length;

        int[][] minValue = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(minValue[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        minQueue.add(new int[]{0,0,1});

        boolean[][] visited = new boolean[n][n];
        while(!minQueue.isEmpty()) {
            int[] node = minQueue.poll();
            int i = node[0];
            int j = node[1];
            int currentValue = node[2];

            visited[i][j] = true;
            if(i == n-1 && j == n - 1) {
                return currentValue;
            }

            if(i+1 < n && !visited[i+1][j] && currentValue + 1 < minValue[i+1][j] && grid[i+1][j] == 0) {
                minValue[i+1][j] = currentValue + 1;
                minQueue.add(new int[]{i+1, j, currentValue + 1});
            }

            if(j+1 < n && !visited[i][j+1] && currentValue + 1 < minValue[i][j+1] && grid[i][j+1] == 0) {
                minValue[i][j+1] = currentValue + 1;
                minQueue.add(new int[]{i, j+1, currentValue + 1});
            }

            if(i+1 < n && j+1 < n && !visited[i+1][j+1] && currentValue + 1 < minValue[i+1][j+1] && grid[i+1][j+1] == 0) {
                minValue[i+1][j+1] = currentValue + 1;
                minQueue.add(new int[]{i+1, j+1, currentValue + 1});
            }
        }

        return minValue[n-1][n-1] == Integer.MAX_VALUE ? -1 : minValue[n-1][n-1];

    }
}