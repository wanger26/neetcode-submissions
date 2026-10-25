class Solution {
    public int calculate(String s) {

        // Time: O(n)
        // Space: O(n)

        Stack<Integer> additions = new Stack<>();

        int number = 0;
        char previousOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (Character.isDigit(character)) {
                number = number * 10 + (character - '0');
            }

            if ((!Character.isDigit(character) && character != ' ') || i == s.length() - 1) {

                if (previousOperator == '+') {
                    additions.push(number);
                } else if (previousOperator == '-') {
                    additions.push(-number);
                } else if (previousOperator == '*') {
                    additions.push(additions.pop() * number);
                } else if (previousOperator == '/') {
                    additions.push(additions.pop() / number);
                }

                previousOperator = character;
                number = 0;
            }
        }

        int result = 0;

        while (!additions.isEmpty()) {
            result += additions.pop();
        }

        return result;
    }
}