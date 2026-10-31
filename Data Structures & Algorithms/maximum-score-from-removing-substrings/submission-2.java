class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder stack = new StringBuilder();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (y < x && !stack.isEmpty() && stack.charAt(stack.length()-1) == 'a' && currentChar == 'b') {
                result += x;
                stack.deleteCharAt(stack.length()-1);
            } else if (x <= y && !stack.isEmpty() && stack.charAt(stack.length()-1) == 'b' && currentChar == 'a') {
                result += y;
                stack.deleteCharAt(stack.length()-1);
            } else {
                stack.append(currentChar);
            }
        }

    
        s = stack.toString();
        stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (y < x && !stack.isEmpty() && stack.charAt(stack.length()-1) == 'b' && currentChar == 'a') {
                result += y;
                stack.deleteCharAt(stack.length()-1);
            } else if (x <= y && !stack.isEmpty() && stack.charAt(stack.length()-1) == 'a' && currentChar == 'b') {
                result += x;
                stack.deleteCharAt(stack.length()-1);
            } else {
                stack.append(currentChar);
            }
        }

        return result;
    }
}
