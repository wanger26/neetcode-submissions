class Solution {
    public int[] luckyNumbers(int[][] matrix) {

        // Time: O(n*m)
        // Space: O(n)

        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> smallestIndexPerRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int smallestIndex = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] < matrix[i][smallestIndex]) {
                    smallestIndex = j;
                }
            }
            smallestIndexPerRow.add(smallestIndex);
        }

        System.out.println(smallestIndexPerRow);
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            int largestIndex = 0;
            for (int i = 1; i < n; i++) {
                if (matrix[i][j] > matrix[largestIndex][j]) {
                    largestIndex = i;
                }
            }

            if(smallestIndexPerRow.get(largestIndex) == j) {
                luckyNumbers.add(matrix[largestIndex][j]);
            }
        }

        return luckyNumbers.stream().mapToInt(i -> i).toArray();
    }
}
