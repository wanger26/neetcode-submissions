class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Time: O(v+e)
        // Space: O(v+e)
        List<Integer>[] graph = new List[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];

            graph[from].add(to); 
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for(int neighbor : graph[node]) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            } 
        }

        return visited == numCourses;
    }
}
