class Solution {
    // Time: O(n)
    // Space: O(n)
    public boolean checkValidString(String s) {
        Stack<Integer> leftBrackets = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        // (**

        for (int i=0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(') {
                leftBrackets.push(i);
            } else if (character == '*') {
                stars.push(i);
            }
            else {
                if (leftBrackets.isEmpty() && stars.isEmpty()) {
                    return false;
                } else if (!leftBrackets.isEmpty()) {
                    leftBrackets.pop();
                } else {
                    stars.pop();
                }
            }
        }

        while(!leftBrackets.isEmpty() && !stars.isEmpty()) {
            if(leftBrackets.pop() > stars.pop()) {
                // If * comes before ( than the solution is no good.
                return false;
            }
        }

        return leftBrackets.isEmpty();
    }
}
