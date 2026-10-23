class Solution {
    public int largestIsland(int[][] grid) {
        // Time: O(n*m))
        // Space: O(n*m)
        int n = grid.length;
        int m = grid[0].length;

        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (hasZero) {
                break;
            }
        }

        if (!hasZero) {
            return n * m;
        }

        int islandId = 1;
        Map<Integer, Integer> islandIdToArea = new HashMap<>();
        int[][] islands = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && islands[i][j] == 0) {
                    int area = dfs(grid, i, j, islands, islandId);
                    islandIdToArea.put(islandId, area);
                    islandId++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> islandsUsed = new HashSet<>();

                    int area = 1;
                    if (i - 1 >= 0 && islands[i - 1][j] != 0) {
                        int islandIdUsed = islands[i - 1][j];
                        islandsUsed.add(islandIdUsed);
                        area += islandIdToArea.get(islandIdUsed);
                    }

                    if (i + 1 < n && islands[i + 1][j] != 0
                        && !islandsUsed.contains(islands[i + 1][j])) {
                        int islandIdUsed = islands[i + 1][j];
                        islandsUsed.add(islandIdUsed);
                        area += islandIdToArea.get(islandIdUsed);
                    }

                    if (j - 1 >= 0 && islands[i][j - 1] != 0
                        && !islandsUsed.contains(islands[i][j - 1])) {
                        int islandIdUsed = islands[i][j - 1];
                        islandsUsed.add(islandIdUsed);
                        area += islandIdToArea.get(islandIdUsed);
                    }

                    if (j + 1 < m && islands[i][j + 1] != 0
                        && !islandsUsed.contains(islands[i][j + 1])) {
                        int islandIdUsed = islands[i][j + 1];
                        islandsUsed.add(islandIdUsed);
                        area += islandIdToArea.get(islandIdUsed);
                    }
                    result = Math.max(result, area);
                }
            }
        }

        return result == 0 ? n * m : result;
    }

    private int dfs(int[][] grid, int i, int j, int[][] islands, int islandId) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0
            || islands[i][j] != 0) {
            return 0;
        }

        islands[i][j] = islandId;

        int result = 1 + dfs(grid, i + 1, j, islands, islandId);
        result += dfs(grid, i - 1, j, islands, islandId);
        result += dfs(grid, i, j + 1, islands, islandId);
        result += dfs(grid, i, j - 1, islands, islandId);

        return result;
    }
}
