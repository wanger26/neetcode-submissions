class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        // Time: O(n)
        // Space: O(n)

        List<Integer>[] subordinates = new List[n];

        for (int i = 0; i < n; i++) {
            subordinates[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates[manager[i]].add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{headID, 0});

        int result = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int employee = current[0];
            int elapsedTime = current[1];

            result = Math.max(result, elapsedTime);

            for (int subordinate : subordinates[employee]) {
                queue.offer(new int[]{
                    subordinate,
                    elapsedTime + informTime[employee]
                });
            }
        }

        return result;
    }
}