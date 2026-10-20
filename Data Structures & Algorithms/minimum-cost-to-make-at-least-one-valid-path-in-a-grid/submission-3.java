class Solution {
    public int minCost(int[][] grid) {

        // Time: O(V + E)
        // Space: O(V + E)
        int n = grid.length;
        int m = grid[0].length;
        List<int[]>[] graph = new List[n*m];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int id = i * m + j;
                int direction = grid[i][j];

                // Up
                if(i > 0) {
                    graph[id].add(new int[]{(i-1) * m + j, direction == 4 ? 0 : 1});
                }

                // Down
                if(i < n - 1) {
                    graph[id].add(new int[]{(i+1) * m + j, direction == 3 ? 0 : 1});
                }

                // Left
                if(j > 0) {
                    graph[id].add(new int[]{i * m + j - 1, direction == 2 ? 0 : 1});
                }

                // Right
                if(j < m - 1) {
                    graph[id].add(new int[]{i * m + j + 1, direction == 1 ? 0 : 1});
                }
            }
        }

        int[] cost = new int[n*m];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] nodeVal = queue.poll();
            int node = nodeVal[0];
            int currentCost = nodeVal[1];

            visited.add(node);

            for(int[] neighbor : graph[node]) {
                int neighborNode = neighbor[0];
                int weight = neighbor[1];

                if (visited.contains(neighborNode)) {
                    continue;
                }

                if(cost[neighborNode] > currentCost + weight) {
                    cost[neighborNode] = currentCost + weight;
                    queue.add(new int[]{neighborNode, cost[neighborNode]});
                }
            }
        }

        return cost[n*m-1];
    }
}
