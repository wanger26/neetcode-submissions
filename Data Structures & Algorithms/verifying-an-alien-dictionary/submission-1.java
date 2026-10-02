class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Time: O(o+w*l) where o is the size of the order w is the length of the words and l is the longest word
        // Space: O(o)
        Map<Character, Integer> rank = new HashMap<>();
        for(int i=0; i < order.length(); i++) {
            rank.put(order.charAt(i), i);
        }

        for(int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            int index = 0;
            int minSize = Math.min(word1.length(), word2.length());
            while(index < word1.length() && index < word2.length() && rank.get(word1.charAt(index)) == rank.get(word2.charAt(index))) {
                index++;
            }

            if(index < minSize && rank.get(word1.charAt(index)) > rank.get(word2.charAt(index))) {
                return false;
            } else if(index == minSize && word2.length() < word1.length()) {
                return false;
            }
        }

        return true;
    }
}