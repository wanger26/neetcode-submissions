class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Time: O(n+e)
        // Space: O(n+e)
        List<Integer>[] prereqGraph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prereqGraph[i] = new ArrayList<>();
        }

        for(int i=0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            prereqGraph[course].add(prereq);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] seen = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!seen[i]) {
                Set<Integer> pathTaken = isPossible(prereqGraph, i, seen, new HashSet<>(), new LinkedHashSet<>());
                if(pathTaken.isEmpty()) {
                    return new int[0];
                }
                result.addAll(pathTaken);
            }
        }

        int[] arrayResult = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            arrayResult[i] = result.get(i);
        }

        return arrayResult;
    }

    private Set<Integer> isPossible(List<Integer>[] prereqGraph, int currentCourse, boolean[] seen, Set<Integer> path, LinkedHashSet<Integer> courseOrder) {
        seen[currentCourse] = true;
        path.add(currentCourse);
        
        for (int prereq : prereqGraph[currentCourse]) {
            if (path.contains(prereq)) {
                return new LinkedHashSet<>();
            } else if (seen[prereq]) {
                continue;
            }
            
            Set<Integer> result = isPossible(prereqGraph, prereq, seen, path, courseOrder);

            if(result.isEmpty()) {
                return result;
            }
        }
        courseOrder.add(currentCourse);
        path.remove(currentCourse);

        return courseOrder;
    }
}
