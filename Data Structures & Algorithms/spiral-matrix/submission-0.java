class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        
        // Define inclusive boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            
            // 1. Traverse from Left to Right along the Top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Shrink the top boundary down
            
            // 2. Traverse from Top to Bottom along the Right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Shrink the right boundary left
            
            // 3. Traverse from Right to Left along the Bottom boundary
            if (top <= bottom) { // Check if we still have a valid row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Shrink the bottom boundary up
            }
            
            // 4. Traverse from Bottom to Top along the Left boundary
            if (left <= right) { // Check if we still have a valid column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Shrink the left boundary right
            }
        }
        
        return result;
    }
}