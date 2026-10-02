class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        // Time: O(m+s) where m is the number of characters in wordDict
        // Space: O(m)
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
        findAllPossibleWords(s, 0, new StringBuilder(), root, root, result);
        return result;
    }

    private void findAllPossibleWords(String s, int index, StringBuilder bldr, Node root, Node currentNode, List<String> result) {
        if(s.length() == index && currentNode.isWord) {
            result.add(bldr.toString());
            return;
        } else if (s.length() == index) {
            return;
        }

        char character = s.charAt(index);
        if(!currentNode.children.containsKey(s.charAt(index))) {
            return;
        }
        bldr.append(character);
        
        if(currentNode.children.get(character).isWord) {
            // Option 1: If node is a word. Add a space and go
            bldr.append(" ");
            findAllPossibleWords(s, index + 1, bldr, root, root, result);
            bldr.deleteCharAt(bldr.length()-1); // Backtrack the space
        }

        // Option 2: Extend word
        Node child = currentNode.children.get(character);
        findAllPossibleWords(s, index + 1, bldr, root, child, result);

        bldr.deleteCharAt(bldr.length()-1); // backtrack the character
    }

    public class Node {
        public Map<Character, Node> children = new HashMap<>();
        public boolean isWord;
    }
}