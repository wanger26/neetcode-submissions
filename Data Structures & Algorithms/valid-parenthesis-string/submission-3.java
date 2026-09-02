class Solution {
    // Time: O(n)
    // Space: O(1)
    public boolean checkValidString(String s) {

        int minOpenBrackets = 0;
        int maxOpenBrackets = 0;

        for(char character : s.toCharArray()) {
            if(character == '(') {
                minOpenBrackets++;
                maxOpenBrackets++;
            } else if (character == '*') {
                minOpenBrackets--;
                maxOpenBrackets++;
            } else {
                minOpenBrackets--;
                maxOpenBrackets--;
            }

            if(maxOpenBrackets < 0) {
                return false;
            } else if (minOpenBrackets < 0) {
                minOpenBrackets = 0;
            }
        }

        return minOpenBrackets == 0;
        
    }
}
