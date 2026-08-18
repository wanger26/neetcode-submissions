class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char character : s.toCharArray()) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), character)) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpposite(char character1, char character2) {
        if (character1 == '(' && character2 == ')') {
            return true;
        } else if (character1 == '[' && character2 == ']') {
            return true;
        } else if (character1 == '{' && character2 == '}') {
            return true;
        }

        return false;
    }
}
