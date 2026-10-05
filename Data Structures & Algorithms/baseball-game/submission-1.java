class Solution {
    public int calPoints(String[] operations) {

        // Time: O(n)
        // Space: O(n)
        Stack<Integer> stack = new Stack<>();

        for(String operation : operations) {
            if(operation.equals("+")) {
                int origToOfStack = stack.pop();
                int result = stack.peek() + origToOfStack;
                stack.push(origToOfStack);
                stack.push(result);
            } else if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(operation));
            }
        }

        int totalSum = 0;
        while(!stack.isEmpty()) {
            totalSum += stack.pop();
        }
        return totalSum;
    }
}