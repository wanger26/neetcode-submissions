class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if (isDigit(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculation(num1, num2, token);
                stack.push(result);
            }
        }
        
        return stack.pop();
    }

    private int calculation(int num1, int num2, String operation) {
        if (operation.equals("+")) {
            return num1 + num2;
        } else if (operation.equals("-")) {
            return num1 - num2;
        } else if (operation.equals("*")) {
            return num1 * num2;
        } else {
            return num1/num2;
        }
    }

    private boolean isDigit(String token) {
        return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
