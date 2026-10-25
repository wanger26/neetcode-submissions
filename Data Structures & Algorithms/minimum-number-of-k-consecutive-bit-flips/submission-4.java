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

                if(i + k > nums.length) {
                    return -1;
                }

                flipedIndexs.add(i);
                result++;
            }
        }

        return result;
    }
}
