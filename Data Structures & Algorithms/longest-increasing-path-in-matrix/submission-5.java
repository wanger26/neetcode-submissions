class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indegree = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftNeighbor = i == 0 ? Integer.MAX_VALUE : matrix[i - 1][j];
                int rightNeighbor = i == n - 1 ? Integer.MAX_VALUE : matrix[i + 1][j];
                int aboveNeighbor = j == 0 ? Integer.MAX_VALUE : matrix[i][j - 1];
                int belowNeighbor = j == m - 1 ? Integer.MAX_VALUE : matrix[i][j + 1];

                if (leftNeighbor < matrix[i][j]) {
                    indegree[i][j]++;
                }

                if (rightNeighbor < matrix[i][j]) {
                    indegree[i][j]++;
                }

                if (aboveNeighbor < matrix[i][j]) {
                    indegree[i][j]++;
                }

                if (belowNeighbor < matrix[i][j]) {
                    indegree[i][j]++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indegree[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int initalSize = queue.size();
            for (int k = 0; k < initalSize; k++) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                int value = matrix[i][j];

                if (i > 0 && value < matrix[i-1][j]) {
                    indegree[i-1][j]--;
                    if(indegree[i-1][j] == 0) {
                        queue.add(new int[]{i-1, j});
                    }
                }
                
                if (i < n-1 && value < matrix[i+1][j]) {
                    indegree[i+1][j]--;
                    if(indegree[i+1][j] == 0) {
                        queue.add(new int[]{i+1, j});
                    }
                }

                if (j > 0 && value < matrix[i][j-1]) {
                    indegree[i][j-1]--;
                    if(indegree[i][j-1] == 0) {
                        queue.add(new int[]{i, j-1});
                    }
                }

                if (j < m-1 && value < matrix[i][j+1]) {
                    indegree[i][j+1]--;
                    if(indegree[i][j+1] == 0) {
                        queue.add(new int[]{i, j+1});
                    }
                }
            }
        }

        return length;
    }
}
