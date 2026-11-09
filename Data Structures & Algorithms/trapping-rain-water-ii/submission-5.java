class Solution {
    public int trapRainWater(int[][] heightMap) {
        // 5 5 5 5 5
        // 0 5 4 2 6
        // 3 4 5 2 3
        // 6 0 5 5 5

        // 5 5 5 5 5
        // 0 5 3 3 6
        // 3 4 5 3 3
        // 6 0 5 5 5

        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++) {
            minHeap.add(new int[]{heightMap[i][0], i, 0});
            minHeap.add(new int[]{heightMap[i][m-1], i, m-1});
            visited[i][0] = true;
            visited[i][m-1] = true;
        }

        for(int j = 0; j < m; j++) {
            minHeap.add(new int[]{heightMap[0][j], 0, j});
            minHeap.add(new int[]{heightMap[n-1][j], n-1, j});
            visited[0][j] = true;
            visited[n-1][j] = true;
        }

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int result = 0;
        while(!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            for(int[] direction : directions) {
                int nextI = i + direction[0];
                int nextJ = j + direction[1];

                if(nextI < 0 || nextI == n || nextJ < 0 || nextJ == m || visited[nextI][nextJ]) {
                    continue;
                }

                visited[nextI][nextJ] = true;
                int nextHeight = heightMap[nextI][nextJ];

                result += Math.max(0, height - nextHeight);

                minHeap.add(new int[]{Math.max(height, nextHeight), nextI, nextJ});
            }
        }

        return result;
    }
}
