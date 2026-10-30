class Solution {

    public long minimumFuelCost(int[][] roads, int seats) {

        // Time: O(n)
        // Space: O(n)
        int n = roads.length;
        List<Integer>[] graph = new List[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        for(int[] edge : roads) {
            int cityA = edge[0];
            int cityB = edge[1];

            graph[cityA].add(cityB);
            graph[cityB].add(cityA);

            indegree[cityA]++;
            indegree[cityB]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 1) {
                queue.add(i);
            }
        }

        boolean[] visited = new boolean[n+1];
        int[] repsAtCity = new int[n+1];
        Arrays.fill(repsAtCity, 1);

        while(!queue.isEmpty()) {
            int city = queue.poll();
            visited[city] =  true;
            for(int neighbor : graph[city]) {
                if(visited[neighbor]) {
                    continue;
                }
                repsAtCity[neighbor] += repsAtCity[city];
                indegree[neighbor]--;
                if(neighbor != 0 && indegree[neighbor] == 1) {
                    queue.add(neighbor);
                }
            }
        }

        long result = 0;
        for(int i = 1; i <= n; i++) {
            result += (repsAtCity[i] + seats - 1) / seats;
        }


        return result;
    }
}
