class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] flowsToPacific = new boolean[n][m];
        boolean[][] seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, -1, seen, flowsToPacific);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, 0, j, -1, seen, flowsToPacific);
        }

        boolean[][] flowsToAtlantic = new boolean[n][m];
        seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m-1, -1, seen, flowsToAtlantic);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, n-1, j, -1, seen, flowsToAtlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(flowsToAtlantic[i][j] && flowsToPacific[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] seen, boolean[][] flowsToSource) {
        if (i < 0 || i == heights.length || j < 0 || j == heights[0].length || seen[i][j]) {
            return;
        }

        if (prevHeight <= heights[i][j]) {
            seen[i][j] = true;
            flowsToSource[i][j] = true;
            dfs(heights, i - 1, j, heights[i][j], seen, flowsToSource);
            dfs(heights, i + 1, j, heights[i][j], seen, flowsToSource);
            dfs(heights, i, j - 1, heights[i][j], seen, flowsToSource);
            dfs(heights, i, j + 1, heights[i][j], seen, flowsToSource);
        }
    }
}
