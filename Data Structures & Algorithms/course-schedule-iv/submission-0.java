class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Integer>[] graph = new List[numCourses];
        Map<Integer, Set<Integer>> courseToPrerecs = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
            courseToPrerecs.put(i, new HashSet<>());
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

        while(!queue.isEmpty()) {
            int prerec = queue.poll();
            
            for(int neighbor : graph[prerec]) {
                courseToPrerecs.get(neighbor).addAll(courseToPrerecs.get(prerec));
                courseToPrerecs.get(neighbor).add(prerec);

                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        

        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries) {
            int prerec = query[0];
            int course = query[1];

            result.add(courseToPrerecs.get(course).contains(prerec));
        }

        return result;
    }
}