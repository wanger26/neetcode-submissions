class Solution {

    private static final Map<Character, Character> CLOSING_PAIRS = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    public boolean isValid(String s) {

        // Time: O(n)
        // Space: O(n)
        Stack<Character> opening = new Stack<>();

        for(char bracket : s.toCharArray()) {
            if(CLOSING_PAIRS.containsKey(bracket)) {
                if(opening.isEmpty() || CLOSING_PAIRS.get(bracket) != opening.peek()) {
                    return false;
                }
                opening.pop();
            } else {
                opening.push(bracket);
            }
        }

        return opening.isEmpty();
    }
}
