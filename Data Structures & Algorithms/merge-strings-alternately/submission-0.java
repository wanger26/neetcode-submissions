class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder bldr = new StringBuilder();

        int index = 0;

        while(index < word1.length() && index < word2.length()) {
            bldr.append(word1.charAt(index));
            bldr.append(word2.charAt(index));
            index++;
        }

        if(index < word1.length()) {
            bldr.append(word1.substring(index));
        } else if (index < word2.length()) {
            bldr.append(word2.substring(index));
        }

        return bldr.toString();
    }
}