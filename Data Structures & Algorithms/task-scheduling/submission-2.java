class Solution {

    // Time: O(m) where m is the number of tasks
    // Space: O(1)
    public int leastInterval(char[] tasks, int n) {
        
        int[] taskCount = new int[26];
        for(char task : tasks) {
            taskCount[task - 'A']++;
        }


        PriorityQueue<Integer> taskCountMaxHeap = new PriorityQueue<>((a,b) -> taskCount[b] - taskCount[a]);
        for(int i = 0; i < 26; i++) {
            if(taskCount[i] > 0) {
                taskCountMaxHeap.add(i);
            }
        }
        
        int[] coolDownTime = new int[26];
        PriorityQueue<Integer> taskCoolDownMinHeap = new PriorityQueue<>((a,b) -> coolDownTime[a]-coolDownTime[b]);

        int currentTime = 0;
        while(!taskCountMaxHeap.isEmpty() || !taskCoolDownMinHeap.isEmpty()) {
            currentTime++;
            while(!taskCoolDownMinHeap.isEmpty() && coolDownTime[taskCoolDownMinHeap.peek()] < currentTime) {
                int index = taskCoolDownMinHeap.poll();
                if(taskCount[index] > 0) {
                    taskCountMaxHeap.add(index);
                }
            }

            if(!taskCountMaxHeap.isEmpty()) {
                int index = taskCountMaxHeap.poll();
                taskCount[index]--;

                if(taskCount[index] > 0) {
                    coolDownTime[index] = currentTime + n;
                    taskCoolDownMinHeap.add(index);
                }
            } else if (!taskCoolDownMinHeap.isEmpty()) {
                currentTime = coolDownTime[taskCoolDownMinHeap.peek()]; // Jump ahead
            }
        }

        return currentTime;

    }
}
