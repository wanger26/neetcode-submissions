class Solution {
    public int lengthOfLastWord(String s) {

        // Time: O(n)
        // Space: O(n)
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}