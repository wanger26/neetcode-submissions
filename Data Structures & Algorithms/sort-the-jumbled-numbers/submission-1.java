class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Time: O(nlogn)
        // Space: O(n)

        int n = nums.length;

        int[] transformedNums = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> {
            if(transformedNums[a] == transformedNums[b]) {
                return a - b;
            }

            return transformedNums[a] - transformedNums[b];
        });

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int transformed = 0;
            int place = 1;
            do {
                int digit = num % 10;
                transformed = transformed + mapping[digit] * place;
                num /= 10;
                place *= 10;
            } while(num > 0);

            transformedNums[i] = transformed;
            minHeap.add(i);
        }


        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[minHeap.poll()];
        }

        return result;

    }
}
