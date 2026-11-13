class Solution {
    public void setZeroes(int[][] matrix) {

        // Time: O(m*n)
        // Space: O(m*n)
        int n = matrix.length;
        int m = matrix[0].length;

        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    stack.push(new int[]{i,j});
                }
            }
        }


        while(!stack.isEmpty()) {
            int[] node = stack.pop();

            int y = node[0];
            int x = node[1];

            for(int i = 0; i < n; i++) {
                matrix[i][x] = 0;
            }

            for(int j = 0; j < m; j++) {
                matrix[y][j] = 0;
            }
        }
    }
}
