class Solution {
    public int reverse(int x) {
        
        int result = 0;
        int currentNumber = x;

        
        while (currentNumber != 0) {
            int digit = currentNumber % 10;
            currentNumber = currentNumber / 10;

            // Making space and adding digit adds an extra byte -> No good
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && digit > 7)) {
                return 0;
            }

            result *= 10; // Make room
            result += digit; // Add digit
        }

        return result;
    }
}
