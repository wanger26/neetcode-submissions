class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int num : nums) {
            maxHeap.add(num);
        }

        long result = 0;
        for(int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            long largestNumber = maxHeap.poll();
            result += largestNumber;

            long updatedNumber = largestNumber / 3;
            if(largestNumber % 3 != 0) {
                updatedNumber++;
            }
            maxHeap.add((int)updatedNumber);
        }

        return result;
    }
}
