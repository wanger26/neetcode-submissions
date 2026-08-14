class Solution {

    // Time complexity: O(n x m x lognm)
    public int swimInWater(int[][] grid) {

        // 0 -> x, 1 -> y
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a,b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        minQueue.add(new int[]{0,0});

        return bfs(0, grid, minQueue, new boolean[grid.length][grid[0].length]);
    }

    private int bfs(int currentLevel, int[][] grid, PriorityQueue<int[]> minQueue, boolean[][] visited) {

        while(!minQueue.isEmpty() && grid[minQueue.peek()[0]][minQueue.peek()[1]] <= currentLevel) {
            int[] coordinates = minQueue.poll();

            if (coordinates[0] == grid.length - 1 &&
    coordinates[1] == grid[0].length - 1) {
    return currentLevel;
}

            int[] top = new int[] {coordinates[0] - 1, coordinates[1]};
            int[] bottom = new int[] {coordinates[0] + 1, coordinates[1]};
            int[] left = new int[] {coordinates[0], coordinates[1] - 1};
            int[] right = new int[] {coordinates[0], coordinates[1] + 1};

            if(validCoordinate(top, grid) && !visited[top[0]][top[1]]) {
                visited[top[0]][top[1]] = true;
                minQueue.add(top);
            }

            if(validCoordinate(bottom, grid) && !visited[bottom[0]][bottom[1]]) {
                visited[bottom[0]][bottom[1]] = true;
                minQueue.add(bottom);
            }

            if(validCoordinate(left, grid) && !visited[left[0]][left[1]]) {
                visited[left[0]][left[1]] = true;
                minQueue.add(left);
            }

            if(validCoordinate(right, grid) && !visited[right[0]][right[1]]) {
                visited[right[0]][right[1]] = true;
                minQueue.add(right);
            }
        }

        return bfs(currentLevel+1, grid, minQueue, visited);
    }

    private boolean validCoordinate(int[] coordinates, int[][] grid) {
        return coordinates[0] >= 0 && coordinates[0] < grid.length && coordinates[1] >= 0 && coordinates[1] < grid[0].length;
    }
}
