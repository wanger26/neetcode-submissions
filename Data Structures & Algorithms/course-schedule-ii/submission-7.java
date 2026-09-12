class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        List<Integer>[] preReqToCourseGraph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preReqToCourseGraph[i] = new ArrayList<>();
        }

        for(int i=0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            preReqToCourseGraph[prereq].add(course);
            indegree[course]++;
        }

        Queue<Integer> availCourses = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                availCourses.add(i);
            }
        }

        int resultIndex = 0;
        int[] result = new int[numCourses];
        while(!availCourses.isEmpty()) {
            int course = availCourses.poll();
            result[resultIndex] = course;
            resultIndex++;
            for(int req : preReqToCourseGraph[course]) {
                indegree[req]--;

                if(indegree[req] == 0) {
                    availCourses.add(req);
                }
            }
        }

        if(resultIndex != numCourses) {
            return new int[0];
        }

        return result;
    }
}
