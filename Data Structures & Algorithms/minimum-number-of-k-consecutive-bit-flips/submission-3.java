class Solution {
    public int minKBitFlips(int[] nums, int k) {

        // 0
        // 0 0 1 0 0

        // Time: O(n)
        // Space: O(n)
        int result = 0;
        Queue<Integer> flipedIndexs = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!flipedIndexs.isEmpty() && flipedIndexs.peek() + k == i) {
                flipedIndexs.poll();
            }

            int number = (nums[i] + flipedIndexs.size()) % 2;
            if(number == 0) {
                flipedIndexs.add(i);
                result++;
            }
        }

        if(!flipedIndexs.isEmpty() && flipedIndexs.peek() + k == nums.length) {
            flipedIndexs.poll();
        }

        return flipedIndexs.isEmpty() ? result : -1;
    }
}
