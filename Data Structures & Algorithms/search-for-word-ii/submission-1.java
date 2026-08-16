class Solution {
    private Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        
        // 1. Fill Word Tree
        for (String word : words) {
            populateTree(root, word);
        }

        boolean[][] used = new boolean[board.length][board[0].length];

        // 2. Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, used);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, Node node, boolean[][] used) {
        // Boundary checks and visited check first
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j]) {
            return;
        }

        char c = board[i][j];
        
        // If the current character is not in the Trie, stop exploring
        if (!node.children.containsKey(c)) {
            return;
        }

        // Move to the next Trie node
        Node nextNode = node.children.get(c);
        
        // If this node contains a full word, we found a match!
        if (nextNode.word != null) {
            result.add(nextNode.word);
            // Optimization: nullify the word so we don't find it again
            nextNode.word = null; 
        }

        // Mark current cell as visited
        used[i][j] = true;

        // Explore all 4 directions safely
        dfs(board, i - 1, j, nextNode, used); // Up
        dfs(board, i + 1, j, nextNode, used); // Down
        dfs(board, i, j - 1, nextNode, used); // Left
        dfs(board, i, j + 1, nextNode, used); // Right

        // Backtrack: unmark the cell
        used[i][j] = false;
    }

    private void populateTree(Node root, String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }
        // Store the full string at the end of the path
        curr.word = word; 
    }

    // Simplified Node class
    class Node {
        Map<Character, Node> children = new HashMap<>();
        String word = null; 
    }
}