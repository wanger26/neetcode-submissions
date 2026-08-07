class WordDictionary {

    /*
        Idea: Use N-Tree, do DFS 
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
            Optional<Node> optionalCurrentNode = currentNode.getChild(character);
            currentNode = optionalCurrentNode.isPresent() ?
             optionalCurrentNode.get():
             currentNode.addChild(character);
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
            for(Node node : currentNode.getAllChildren()) {
                boolean matchFound = dfs(word, index + 1, node);

                if (matchFound) {
                    return true;
                }
            }
        } else if (currentNode.getChild(character).isPresent()){
            return dfs(word, index+1, currentNode.getChild(character).get());
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

        Node addChild(char character) {
            Node newNode = new Node(character);
            this.children.put(character, newNode);

            return newNode;
        }

        Collection<Node> getAllChildren() {
            return this.children.values();
        }

        Optional<Node> getChild(char character) {
            return Optional.ofNullable(this.children.get(character));
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
