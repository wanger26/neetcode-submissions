class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Time: O(n)
        // Space: O(n)
        Deque<Integer> queue = new ArrayDeque<>();

        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++) {

            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.add(i);

            if(queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }

            if(i + 1 >= k) {
                result[i-k+1] = nums[queue.peek()];
            }
        }

        return result;
    }
}
