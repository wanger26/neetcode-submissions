class PrefixTree {

    private Node head;

    public PrefixTree() {
         this.head = new Node();
    }

    // Time: O(w)
    public void insert(String word) {
        Node currentNode = head;
        for(char character : word.toCharArray()) {
            Optional<Node> optionalNode = currentNode.containsCharacter(character);
            
            // FIXED: Replaced the lambda with a standard if/else to avoid the effectively final error
            if(optionalNode.isEmpty()) {
                Node newNode = new Node();
                currentNode.add(character, newNode);
                currentNode = newNode;
            } else {
                currentNode = optionalNode.get();
            }
        }
        currentNode.setIsWord(true);
    }

    // Time: O(w)
    public boolean search(String word) {
        Node currentNode = head;
        for(char character : word.toCharArray()) {
            Optional<Node> optionalNode = currentNode.containsCharacter(character);
            if(optionalNode.isEmpty()) {
                return false;
            } else {
                currentNode = optionalNode.get();
            }
        }
        return currentNode.isWord();
    }

    // Time: O(w)
    public boolean startsWith(String prefix) {
        Node currentNode = head;
        // FIXED: Changed 'word' to 'prefix'
        for(char character : prefix.toCharArray()) {
            Optional<Node> optionalNode = currentNode.containsCharacter(character);
            if(optionalNode.isEmpty()) {
                return false;
            } else {
                currentNode = optionalNode.get();
            }
        }
        return true;
    }

    class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean isWord = false;

        // FIXED: Added the 's' to match the method calls
        Optional<Node> containsCharacter(char character) {
            if(children.containsKey(character)) {
                return Optional.of(children.get(character));
            }
            return Optional.empty();
        }

        void add(char character, Node newNode) {
            children.put(character, newNode);
        }

        void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        boolean isWord() {
            return isWord;
        }
    }
}