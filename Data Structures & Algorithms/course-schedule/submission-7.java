class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1 --> 2
        // 2 --> 3
        // 3 --> 2
        Map<Integer, Set<Integer>> preqToCourseMap = new HashMap<>();

        for (int[] preq : prerequisites) {
            int preqCourse = preq[1];
            int otherCourse = preq[0];
            if (!preqToCourseMap.containsKey(preqCourse)) {
                preqToCourseMap.put(preqCourse, new HashSet<>());
            }
            preqToCourseMap.get(preqCourse).add(otherCourse);
        }

        Set<Integer> seen = new HashSet<>();
        for (int[] preq : prerequisites) {
            int preqCourse = preq[1];
            if (seen.contains(preqCourse)) {
                continue;
            }
            boolean canFinish = dfs(preqToCourseMap, preqCourse, seen, new HashSet<>());
            seen.add(preqCourse);

            if (!canFinish) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> preqToCourseMap, int preqCourse,
        Set<Integer> seen, Set<Integer> inPath) {
        if (inPath.contains(preqCourse)) {
            return false;
        } else if (!preqToCourseMap.containsKey(preqCourse) || seen.contains(preqCourse)) {
            return true;
        }

        inPath.add(preqCourse);

        for (int course : preqToCourseMap.get(preqCourse)) {
            boolean valid = dfs(preqToCourseMap, course, seen, inPath);

            if (!valid) {
                return false;
            }
        }

        inPath.remove(preqCourse);
        seen.add(preqCourse);

        return true;
    }
}
