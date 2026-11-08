class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if(m*n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        for(int i = 0; i < original.length; i++) {
            int y = i / n;
            int x = i % n;

            result[y][x] = original[i];
        }

        return result;
    }
}
