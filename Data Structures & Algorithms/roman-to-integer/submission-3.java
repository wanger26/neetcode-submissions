class Solution {
    public int romanToInt(String s) {

        // Time: O(n)
        // Space: O(1)

        int prev = 0;
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
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
            
            if (number < prev) {
                result -= number;
            }
            else {
                result += number;
            }

            prev = number;
        }

        return result;
    }
}