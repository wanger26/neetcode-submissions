class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int max = 0;
        for(int num : nums) {
            int minNum = num;
            while(minNum % 2 == 0) {
                minNum /= 2;
            }

            int limit = num % 2 == 1 ? num * 2 : num;
            minHeap.add(new int[]{minNum, limit});
            max = Math.max(max, minNum);
        }

        int result = Integer.MAX_VALUE;
        while(minHeap.size() == nums.length) {
            int[] num = minHeap.poll();
            int smallestNum = num[0];
            int limit = num[1];
            

            if(smallestNum == limit) {
                continue;
            }

            int newNum = smallestNum * 2;
            num[0] = newNum;
            minHeap.add(num);
            max = Math.max(max, newNum);
            result = Math.min(max - minHeap.peek()[0], result);
        }

        return result;
    }
}
