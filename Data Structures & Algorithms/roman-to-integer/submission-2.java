class Solution {
    public int romanToInt(String s) {

        // Time: O(n)
        // Space: O(n)

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            int number = switch (character) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                default -> 1000;
            };
            
            if (!stack.isEmpty() && stack.peek() < number) {
                result += number - stack.pop();
            }
            else {
                stack.push(number);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}