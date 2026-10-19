class Solution {
    public int longestSubarray(int[] nums, int limit) {

        // Time: O(nlogn)
        // Space: O(n)
        PriorityQueue<Integer> minNumbers = new PriorityQueue<Integer>((a,b) -> nums[a] - nums[b]);
        PriorityQueue<Integer> maxNumbers = new PriorityQueue<Integer>((a,b) -> nums[b] - nums[a]);

        int left = 0;
        int right = 0;

        int result = 0;
        while(right < nums.length) {

            minNumbers.add(right);
            maxNumbers.add(right);

            while(nums[maxNumbers.peek()] - nums[minNumbers.peek()] > limit) {
                left++;

                while(!minNumbers.isEmpty() && minNumbers.peek() < left) {
                    minNumbers.poll();
                }

                while(!maxNumbers.isEmpty() && maxNumbers.peek() < left) {
                    maxNumbers.poll();
                }
            }
            
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}