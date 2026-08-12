class Solution {

    private int result = 0;
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        bfs(nums, queue, new HashSet<>());

        return result;
    }

    private void bfs(int[] nums, Queue<Integer> queue, Set<Integer> seen) {
        result++;

        int origSize = queue.size();
        for(int i = 0; i < origSize; i++) {
            int index = queue.poll();

            if(seen.contains(index)) {
                continue;
            }

            seen.add(index);

            if(index + nums[index] >= nums.length - 1) {
                return;
            }

            for(int j=1; j <= nums[index] && j + index < nums.length; j++) {
                queue.add(j+index);
            }
        }

        bfs(nums, queue, seen);
    }
}
