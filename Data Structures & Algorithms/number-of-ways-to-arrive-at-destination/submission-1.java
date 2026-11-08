class Solution {
    public int countPaths(int n, int[][] roads) {

        if(n == 1) {
            return 1;
        }
        
        List<int[]>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : roads) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

            graph[node1].add(new int[]{node2, weight});
            graph[node2].add(new int[]{node1, weight});
        }

        int[] timeForEachNode = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 1; i < n; i++) {
            timeForEachNode[i] = Integer.MAX_VALUE;
        }

        int[] numberOfWays = new int[n];
        numberOfWays[0] = 1;

        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a,b) -> timeForEachNode[a] - timeForEachNode[b]);
        minQueue.add(0);

        while(!minQueue.isEmpty()) {
            int node = minQueue.poll();
            if(visited[node]) {
                continue;
            }

            System.out.println("Visiting Node: " + node);
            visited[node] = true;
            int nodeTime = timeForEachNode[node];
            int nodeWays = numberOfWays[node];

            for(int[] neighbor : graph[node]) {
                int neighborId = neighbor[0];
                int neighborTime = neighbor[1];

                if(visited[neighborId]) {
                    continue;
                }

                int time = nodeTime + neighborTime;
                if(time <= timeForEachNode[neighborId]) {
                    if(time == timeForEachNode[neighborId]) {
                        numberOfWays[neighborId] = (numberOfWays[neighborId] + nodeWays) % 1000000007;
                    } else {
                        numberOfWays[neighborId] = nodeWays;
                    }

                    timeForEachNode[neighborId] = time;
                    minQueue.add(neighborId);
                }
            }
        }

        return numberOfWays[n-1];
    }
}
