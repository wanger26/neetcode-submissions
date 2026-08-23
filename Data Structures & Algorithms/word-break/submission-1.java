class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Populate Dictionary
        Node root = new Node();
        for(String word : wordDict) {
            Node currentNode = root;
            for(char character : word.toCharArray()) {
                currentNode = currentNode.addCharacterToNodes(character);
            }
            currentNode.setIsWord(true);
        }

        return dfs(s, 0, root, root, new HashMap<>());
    }

    private boolean dfs(String s, int index, Node root, Node currentNode, Map<Key, Boolean> memo) {
        Key key = new Key(index, currentNode);
        if (memo.containsKey(key)) {
            return memo.get(key);
        } else if (index == s.length()) {
            return currentNode.isWord();
        }

        Optional<Node> optionalNode = currentNode.getCharacter(s.charAt(index));
        if(optionalNode.isEmpty()) {
            return false;
        }
        Node node = optionalNode.get();
        boolean result = false;
        if(node.isWord()) {
            result = dfs(s, index + 1, root, root, memo);
        }

        memo.put(key, result || dfs(s, index + 1, root, node, memo));
        return memo.get(key);
    }

    private record Key(int index, Node node){}

    private class Node {

        private final Map<Character, Node> characterToNodes;
        private boolean isWord;

        public Node() {
            this.characterToNodes = new HashMap<>();
            this.isWord = false;
        }

        public void setIsWord(boolean isWord){
            this.isWord = isWord;
        }

        public boolean isWord(){
            return this.isWord;
        }

        public Node addCharacterToNodes(char character) {
            characterToNodes.putIfAbsent(character, new Node());
            return characterToNodes.get(character);
        }

        public Optional<Node> getCharacter(char character) {
            return Optional.ofNullable(characterToNodes.get(character));
        }
    }
}
