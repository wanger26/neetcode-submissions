class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Time: O(n)
        // Time: O(k)
        int n = nums.length;
        int[] result = new int[n + 1 - k];

        int left = 0;
        int right = 0;

        Deque<Integer> queue = new LinkedList<>();

        while(right < n) {
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
                queue.removeLast();
            }

            queue.add(right);

            if(left > queue.getFirst()) {
                queue.removeFirst();
            }

            if(right + 1 >= k) {
                result[left] = nums[queue.getFirst()];
                left++;
            }

            right++;
        }

        return result;
    }
}
