class Solution {
    public int numTilePossibilities(String tiles) {
        // Time: O(n!)
        // Space: O(n!)
        char[] tilesArray = tiles.toCharArray();
        Arrays.sort(tilesArray);

        return backtracking(tilesArray, new boolean[tiles.length()]);
    }

    private int backtracking(char[] tiles, boolean[] used) {
        int result = 0;
        for(int i = 0; i < tiles.length; i++) {
            if(used[i] || (i > 0 && !used[i-1] && tiles[i] == tiles[i-1])) {
                continue;
            }
            used[i] = true;
            result += 1 + backtracking(tiles, used);
            used[i] = false;
        }

        return result;
    }
}
