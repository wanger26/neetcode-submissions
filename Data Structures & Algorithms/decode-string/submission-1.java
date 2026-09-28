class Solution {
    public String decodeString(String s) {

        // Time: O(n*N) where n is size of input string and N is the lenght of the output string
        // Space: O(n*N) where n is size of input string and N is the lenght of the output string

        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int k = 0;

        StringBuilder bldr = new StringBuilder();
        for(char character : s.toCharArray()) {
            if(Character.isDigit(character)) {
                k = k * 10 + (character - '0');
            } else if(character == '[') {
                stringStack.push(bldr.toString());
                countStack.push(k);

                bldr = new StringBuilder();
                k = 0;
            } else if (character == ']') {
                String string = bldr.toString();
                bldr = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for(int i = 0; i < count; i++) {
                    bldr.append(string);
                }
            } else {
                bldr.append(character);
            }
        }

        return bldr.toString();
    }
}