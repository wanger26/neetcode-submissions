class WordDictionary {

    /*
        Idea: Use N-Tree, do BFS 
    */
    private final Node root;

    public WordDictionary() {
        this.root = new Node(null);
    }

    public void addWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word must not be null");
        }

        Node currentNode = root;
        for (char character : word.toCharArray()) {
            if(!currentNode.getChildren().containsKey(character)) {
                currentNode.addChild(character);
            }
            currentNode = currentNode.getChildren().get(character);
        }
        currentNode.setAsCompleteWord();
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node currentNode) {
        if (index == word.length()) {
            return currentNode.isCompleteWord();
        }

        char character = word.charAt(index);
        // System.out.println("character: " + character);
        // currentNode.toLog();
        if (character == '.') {
            for(Node node : currentNode.getChildren().values()) {
                boolean matchFound = dfs(word, index + 1, node);

                if (matchFound) {
                    return true;
                }
            }
        } else if (currentNode.getChildren().containsKey(character)){
            return dfs(word, index+1, currentNode.getChildren().get(character));
        }

        return false;
    }


    class Node {
        private boolean isCompleteWord;
        private final Map<Character, Node> children;

        Node(Character value) {
            this.isCompleteWord = false;
            this.children = new HashMap<>();
        }

        Map<Character, Node> getChildren() {
            return this.children;
        }

        void addChild(char character) {
            this.children.put(character, new Node(character));
        }

        void setAsCompleteWord() {
            this.isCompleteWord = true;
        }

        boolean isCompleteWord() {
            return this.isCompleteWord;
        }

        void toLog() {
            System.out.println("Children: " + this.children.keySet());
        }


    }
}
