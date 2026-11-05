class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] timeToComplete = time.clone();

        List<Integer>[] graph = new List[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        for(int[] edge : relations) {
            int from = edge[0];
            int to = edge[1];
        
            graph[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int neighbor : graph[node]) {
                timeToComplete[neighbor-1] = Math.max(timeToComplete[neighbor-1], timeToComplete[node-1] + time[neighbor-1]);
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            result = Math.max(result, timeToComplete[i]);
        }

        return result;

    }
}
