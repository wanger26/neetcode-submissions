class Solution {
    public int numMagicSquaresInside(int[][] grid) {

        // Time: O(n*m)
        // Space: O(1)
        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                boolean valid = true;

                boolean[] seen = new boolean[10];
                for (int colOffset = 0; colOffset < 3 && valid; colOffset++) {
                    int rowSum = 0;
                    for (int rowOffset = 0; rowOffset < 3 && valid; rowOffset++) {
                        int value = grid[i + colOffset][j + rowOffset];
                        if (value < 1 || value > 9 || seen[value] ) {
                            valid = false;
                            continue;
                        } else {
                            rowSum += value;
                        }
                        seen[value] = true;
                    }

                    if(valid) {
                        valid = rowSum == 15;
                    }
                }

                for (int rowOffset = 0; rowOffset < 3 && valid; rowOffset++) {
                    int colSum = 0;
                    for (int colOffset = 0; colOffset < 3 && valid; colOffset++) {
                        int value = grid[i + colOffset][j + rowOffset];
                        colSum += value;
                    }
                    valid = colSum == 15;
                }

                int diagonal1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                int diagonal2 = grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2];

                if(valid && diagonal1 == 15 && diagonal2 == 15) {
                    result++;
                }
            }
        }
        return result;
    }
}
