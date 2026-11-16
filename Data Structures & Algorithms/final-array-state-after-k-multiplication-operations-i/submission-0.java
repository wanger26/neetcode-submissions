class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        // Time: O(nlogn + klogn)
        // Space: O(n)
        int[] result = new int[nums.length];
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((a,b) -> {
            if(result[a] - result[b] == 0) {
                return a - b;
            }
            return result[a] - result[b];
        });

        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            minQueue.add(i);
        }

        for(int i = 0; i < k; i++) {
            int index = minQueue.poll();
            result[index] *= multiplier;
            minQueue.add(index);
        }

        return result;
    }
}