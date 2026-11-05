class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Input: s = "neetcodes", wordDict = ["neet","codes", "neetcode"]
        Node root = new Node();
        Node current = root;
        for(String word : wordDict) {
            for(int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                if(!current.children.containsKey(character)) {
                    current.children.put(character, new Node());
                }
                current = current.children.get(character);
            }
            current.isWord = true;
            current = root;
        }

        return canBeSegemented(root, root, s, 0, new HashMap<>());
    }

    private boolean canBeSegemented(Node root, Node current, String s, int index, Map<Integer, Boolean> memo) {
        if(s.length() == index) {
            return true;
        } else if (memo.containsKey(index)) {
            return memo.get(index);
        }

        boolean result = false;
        for(int i = index; i < s.length() && !result; i++) {
            char character = s.charAt(i);
            if(!current.children.containsKey(character)) {
                memo.put(index, false);
                return false;
            }

            current = current.children.get(character);
            if (current.isWord) {
                result = canBeSegemented(root, root, s, i+1, memo);
            }
        }
        
        if(!result) {
            result = current.isWord;
        }

        memo.put(index, result);
        return result;
    }

    class Node {
        final Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }
}
