class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int thirdValue = Integer.MIN_VALUE;

        for(int i = nums.length-1; i >= 0; i--) {

            int current = nums[i];

            if(current < thirdValue) {
                return true;
            }

            while(!stack.isEmpty() && current > stack.peek()) {
                thirdValue = stack.pop();
            }

            stack.push(current);
        }

        return false;
    }
}
