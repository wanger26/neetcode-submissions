class Solution {
    // 1. Simplified Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // Only populated at the end of a valid word
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Build the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // Mark the end of the word
        }

        List<String> result = new ArrayList<>();
        
        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        // Boundary checks
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];
        
        // If already visited ('#') or no matching character in the Trie
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        // Move to the next node in the Trie
        TrieNode nextNode = node.children[c - 'a'];

        // If we found a word, add it and remove it from Trie to avoid duplicates
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; 
        }

        // Mark the current cell as visited
        board[i][j] = '#';

        // Explore all 4 directions
        dfs(board, i - 1, j, nextNode, result); // Up
        dfs(board, i + 1, j, nextNode, result); // Down
        dfs(board, i, j - 1, nextNode, result); // Left
        dfs(board, i, j + 1, nextNode, result); // Right

        // Backtrack: Restore the cell's original character
        board[i][j] = c;
    }
}