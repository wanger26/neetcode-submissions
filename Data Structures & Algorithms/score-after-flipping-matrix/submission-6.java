class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int j = 1; j < m; j++) {
            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount > n - zeroCount) {
                for (int i = 0; i < n; i++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int number = 0;
            int power = 1;
            for(int j = m-1; j >= 0; j--) {
                number += grid[i][j] * power;
                power *= 2;
            }
            result += number;
        }

        return result;
    }
}
