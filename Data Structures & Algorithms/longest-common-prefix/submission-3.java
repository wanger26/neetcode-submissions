class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Time: O(n * m) where n is the number of strings and m is the shortest string
        // Time: O(1)
        StringBuilder bldr = new StringBuilder();
        int charIndex = 0;
        while (charIndex < strs[0].length()) {
            char requiredChar = strs[0].charAt(charIndex);
            for (int i = 1; i < strs.length; i++) {
                if(charIndex == strs[i].length() || requiredChar != strs[i].charAt(charIndex)) {
                    return bldr.toString();
                }
            }
            bldr.append(requiredChar);
            charIndex++;
        }

        return bldr.toString();
    }
}