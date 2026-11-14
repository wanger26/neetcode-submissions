class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // Time: O(m*n)
        // Space: O(m*n)
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] fromPacific = new boolean[n][m];
        boolean[][] fromAtlantic = new boolean[n][m];
        for(int j = 0; j < m; j++) {
            dfs(heights, 0, j, -1, fromPacific);
            dfs(heights, n-1, j, -1, fromAtlantic);
        }

        for(int i = 0; i < n; i++) {
            dfs(heights, i, 0, -1, fromPacific);
            dfs(heights, i, m-1, -1, fromAtlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(fromPacific[i][j] && fromAtlantic[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] visited) {
        if(i < 0 || j < 0 || i == heights.length || j == heights[0].length || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;
        dfs(heights, i - 1, j, heights[i][j], visited);
        dfs(heights, i + 1, j, heights[i][j], visited);
        dfs(heights, i, j - 1, heights[i][j], visited);
        dfs(heights, i, j + 1, heights[i][j], visited);
    }
}
