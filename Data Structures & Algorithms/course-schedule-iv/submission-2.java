class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        // Time: O(v*e + q)
        // Space: O(v^2 + e)
        List<Integer>[] graph = new List[numCourses];
        boolean[][] courseToPrerecs = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            int prerecCourse = edge[0];
            int course = edge[1];

            graph[prerecCourse].add(course);
            indegree[course]++;
        }

        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        
        while(!queue.isEmpty()) { // O(v)
            int prerec = queue.poll();
            
            for(int neighbor : graph[prerec]) { // O(e)
                for (int i = 0; i < numCourses; i++) {
                    if (courseToPrerecs[prerec][i]) {
                        courseToPrerecs[neighbor][i] = true;
                    }
                }
                courseToPrerecs[neighbor][prerec] = true;

                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        

        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries) { // O(q)
            int prerec = query[0];
            int course = query[1];

            result.add(courseToPrerecs[course][prerec]);
        }

        return result;
    }
}