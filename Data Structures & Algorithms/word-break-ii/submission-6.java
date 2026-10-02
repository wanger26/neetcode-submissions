class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        // Time: O(m+s*2^s) where m is the number of characters in wordDict
        // Space: O(m+s^2)
        Node root = new Node();
        for(String word : wordDict) {
            Node currentNode = root;
            for(int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                if(!currentNode.children.containsKey(character)) {
                    currentNode.children.put(character, new Node());
                }
                currentNode = currentNode.children.get(character);
            }
            currentNode.isWord = true;
        }

        List<String> result = new ArrayList<>();
        findAllPossibleWords(s, 0, new StringBuilder(), root, root, result, new Boolean[s.length()]);
        return result;
    }

    private boolean findAllPossibleWords(String s, int index, StringBuilder bldr, Node root, Node currentNode, List<String> result, Boolean[] memo) {
        if(s.length() == index && currentNode.isWord) {
            result.add(bldr.toString());
            return true;
        } else if (s.length() == index) {
            return false;
        } else if(root == currentNode && memo[index] != null && !memo[index]) {
            return memo[index];
        }

        boolean foundValidAnswer = false;

        char character = s.charAt(index);
        if(!currentNode.children.containsKey(s.charAt(index))) {
            if(root == currentNode) {
                memo[index] = false;
            }
            return false;
        }
        bldr.append(character);
        
        if(currentNode.children.get(character).isWord) {
            // Option 1: If node is a word. Add a space and go
            bldr.append(" ");
            if(findAllPossibleWords(s, index + 1, bldr, root, root, result, memo)) {
                foundValidAnswer = true;
            }
            bldr.deleteCharAt(bldr.length()-1); // Backtrack the space
        }

        // Option 2: Extend word
        Node child = currentNode.children.get(character);
        if(findAllPossibleWords(s, index + 1, bldr, root, child, result, memo)) {
            foundValidAnswer = true;
        }

        bldr.deleteCharAt(bldr.length()-1); // backtrack the character

        if(root == currentNode) {
            memo[index] = foundValidAnswer;
        }

        return foundValidAnswer;
    }

    public class Node {
        public Map<Character, Node> children = new HashMap<>();
        public boolean isWord;
    }
}