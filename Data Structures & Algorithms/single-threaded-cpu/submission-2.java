class Solution {
    public int[] getOrder(int[][] tasks) {

        // Time: O(nlogn)
        // Space: O(n)
        PriorityQueue<Integer> tasksByStartTime = new PriorityQueue<>((a,b) -> {
            int result = tasks[a][0] - tasks[b][0];
            if(result != 0) {
                return result;
            }
            return tasks[a][1] - tasks[b][1];
        });

        for(int i=0; i < tasks.length; i++) {
            tasksByStartTime.add(i);
        }

        PriorityQueue<Integer> tasksReadyToGo = new PriorityQueue<>((a,b) -> {
            int result = tasks[a][1] - tasks[b][1];

            if(result != 0) {
                return result;
            }

            return a-b;
        });
        int first = tasksByStartTime.poll();
        long endTime = tasks[first][0];
        tasksReadyToGo.add(first);
    

        int index = 0;
        int[] result = new int[tasks.length];
        while(!tasksReadyToGo.isEmpty()) {
            int taskIndex = tasksReadyToGo.poll();
            result[index++] = taskIndex;

            endTime += tasks[taskIndex][1];
            if(tasksReadyToGo.isEmpty() && !tasksByStartTime.isEmpty() && endTime < tasks[tasksByStartTime.peek()][0]) {
                endTime = tasks[tasksByStartTime.peek()][0];
            }

            while(!tasksByStartTime.isEmpty() && tasks[tasksByStartTime.peek()][0] <= endTime) {
                tasksReadyToGo.add(tasksByStartTime.poll());
            }
        }

        return result;
    }
}