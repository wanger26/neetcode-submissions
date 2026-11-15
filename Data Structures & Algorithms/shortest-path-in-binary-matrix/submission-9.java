class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int[][] directions = {
            {-1,0},
            {0,-1},
            {-1,-1},
            {1,0},
            {0,1},
            {1,1},
            {-1,1},
            {1,-1}
        };

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int value = node[2];

            if(i == n-1 && j == n-1) {
                return value;
            }

            for(int[] direction : directions) {
                int nextI = i + direction[0];
                int nextJ = j + direction[1];

                if(nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n || visited[nextI][nextJ] || grid[nextI][nextJ] != 0) {
                    continue;
                }

                visited[nextI][nextJ] = true;
                queue.add(new int[]{nextI, nextJ, value + 1});
            }
        }

        return -1;
        
    }
}