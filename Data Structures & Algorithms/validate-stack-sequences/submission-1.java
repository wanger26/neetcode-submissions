class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        // Time: O(n)
        // Space: O(n)
        if(pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0;
        int poppedIndex = 0;

        while (pushIndex < pushed.length && poppedIndex < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[poppedIndex]) {
                stack.push(pushed[pushIndex++]);
            } else {
                stack.pop();
                poppedIndex++;
            }
        }

        while (poppedIndex < popped.length && !stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
            stack.pop();
            poppedIndex++;
        }

        return stack.isEmpty();
    }
}
