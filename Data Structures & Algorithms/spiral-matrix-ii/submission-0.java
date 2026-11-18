class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];

        int upLimit = 0;
        int downLimit = n-1;
        int leftLimit = 0;
        int rightLimit = n-1;

        int num = 1;
        while(num <= n*n) {

            // Left to right
            for(int j = leftLimit; j <= rightLimit; j++) {
                result[upLimit][j] = num;
                num++;
            }
            upLimit++;

            // Up to down
            for(int i = upLimit; i <= downLimit; i++) {
                result[i][rightLimit] = num;
                num++;
            }
            rightLimit--;

            // Right to left
            for(int j = rightLimit; j >= leftLimit; j--) {
                result[downLimit][j] = num;
                num++;
            }
            downLimit--;

            // Down to up
            for(int i = downLimit; i >= upLimit; i--) {
                result[i][leftLimit] = num;
                num++;
            }
            leftLimit++;
        }

        return result;
    }
}