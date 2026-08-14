class Solution {
    public void rotate(int[][] matrix) {
         int leftBoundry = 0;
         int rightBoundry = matrix.length - 1;
         int topBoundry = 0;
         int bottomBoundry = matrix.length - 1;

         while(leftBoundry < rightBoundry) {

            // Iterate through the layers
            for(int i = 0; i < (rightBoundry - leftBoundry); i++) {
                
                // Save top left
                int temp = matrix[topBoundry][leftBoundry+i];
                
                // Move bottom left to top left
                matrix[topBoundry][leftBoundry+i] = matrix[bottomBoundry-i][leftBoundry];

                // Move bottom right to bottom left
                matrix[bottomBoundry-i][leftBoundry] = matrix[bottomBoundry][rightBoundry-i];

                // Move top right to bottom right
                matrix[bottomBoundry][rightBoundry-i] = matrix[topBoundry+i][rightBoundry];

                // Move top left to top right
                matrix[topBoundry+i][rightBoundry] = temp;
            }
   

            leftBoundry++;
            rightBoundry--;

            topBoundry++;
            bottomBoundry--;
         }
    }

}
