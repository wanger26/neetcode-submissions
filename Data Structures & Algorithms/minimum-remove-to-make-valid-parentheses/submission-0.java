class Solution {
    public String minRemoveToMakeValid(String s) {

        // Time: O(n)
        // Space: O(n)
        Set<Integer> removals = new HashSet<>();
        Stack<Integer> openingBrackets = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current != '(' && current != ')') {
                continue;
            } else if (current == '(') {
                openingBrackets.push(i);
            } else if (openingBrackets.isEmpty()) {
                // Closing bracket when no open one
                removals.add(i);
            } else {
                // Closing bracket and can close it
                openingBrackets.pop();
            }
        }

        while(!openingBrackets.isEmpty()) {
            removals.add(openingBrackets.pop());
        }

        StringBuilder bldr = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(removals.contains(i)) {
                continue;
            }
            bldr.append(s.charAt(i));
        }

        return bldr.toString();
    }
}