class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        
        Node headNode = new Node();

        // O(w*m) where w is lenght of words and m is length longest word
        for (String word : dictionary) {
            Node currentNode = headNode;
            for (char character : word.toCharArray()) {
                if(!currentNode.getChars().containsKey(character)) {
                    Node newNode = new Node();
                    currentNode.getChars().put(character, newNode);
                }
                currentNode = currentNode.getChars().get(character);
            }
            currentNode.isWord(true);
        }

        return dp(s, 0, headNode, new Integer[s.length()]);
    }

    private int dp(String s, int index, Node root, Integer[] memo) {
        if(index == s.length()) {
            return 0;
        } else if (memo[index] != null) {
            return memo[index];
        }

        // Option 1: Skip the current character
        int result = 1 + dp(s, index+1, root, memo);


        // Option 2: Traverse the trie to find all valid words starting at index
        Node currentNode = root;
        for(int i = index; i < s.length() && currentNode.getChars().containsKey(s.charAt(i)); i++) {
            currentNode = currentNode.getChars().get(s.charAt(i));
            
            if(currentNode.isWord()) {
                result = Math.min(result, dp(s, i+1, root, memo));
            }
        }

        memo[index] = result;

        return result;
    }

    class Node {
        private Map<Character, Node> chars = new HashMap<>();
        private boolean isWord = false;

        public Map<Character, Node> getChars() {
            return this.chars;
        }

        public boolean isWord() {
            return this.isWord;
        }

        public void isWord(boolean isWord) {
            this.isWord = isWord;
        }
    }
}