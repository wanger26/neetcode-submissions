class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Time: O(m*n*4*3^l+s) where l is the longest number of words and s is the total lenght of all words
    // Space: O(s)

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        Node root = new Node();
        for (String word : words) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                if (!current.children.containsKey(character)) {
                    current.children.put(character, new Node());
                }
                current = current.children.get(character);
            }
            current.word = word;
        }

        Set<String> result = new HashSet<>();
        boolean[][] used = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char character = board[i][j];
                if(root.children.containsKey(character)) {
                    dfs(root.children.get(character), result, board, i, j, used);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(Node current, Set<String> result, char[][] board, int i, int j, boolean[][] used) {
        if (current == null) {
            return;
        } else if (current.word != null) {
            result.add(current.word);
        }

        used[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (isValid(nextI, nextJ, used) && current.children.containsKey(board[nextI][nextJ])) {
                dfs(current.children.get(board[nextI][nextJ]), result, board, nextI, nextJ, used);
            }
        }
        used[i][j] = false;
    }

    private boolean isValid(int i, int j, boolean[][] used) {
        return !(i < 0 || j < 0 || i == used.length || j == used[0].length || used[i][j]);
    }

    class Node {
        Map<Character, Node> children = new HashMap<>();
        String word;
    }
}
