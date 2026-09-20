class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        // Time: O(k + r + c) where r is the number of rowConditions and c is colConditions
        // Space: O(k + r + c)
        int[][] result = new int[k][k];

        List<Integer>[] rowGraph = new List[k+1];
        int[] rowIndegree = new int[k+1];
        for(int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<>();
        }

        for(int[] rowCondition : rowConditions) {
            int above = rowCondition[0];
            int below = rowCondition[1];

            rowGraph[above].add(below);
            rowIndegree[below]++;
        }

        int[] rowIndex = toplogicalSort(rowGraph, rowIndegree, k);

        if(rowIndex == null) {
            return new int[0][0];
        }

        List<Integer>[] colGraph = new List[k+1];
        int[] colIndegree = new int[k+1];
        for(int i = 1; i <= k; i++) {
            colGraph[i] = new ArrayList<>();
        }

        for(int[] colCondition : colConditions) {
            int left = colCondition[0];
            int right = colCondition[1];

            colGraph[left].add(right);
            colIndegree[right]++;
        }

        int[] colIndex = toplogicalSort(colGraph, colIndegree, k);

        if(colIndex == null) {
            return new int[0][0];
        }

        for(int i = 1; i <= k; i++) {
            int x = rowIndex[i];
            int y = colIndex[i];

            result[x][y] = i;
        }

        return result;
    }

    private int[] toplogicalSort(List<Integer>[] graph, int[] indegree, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= k; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        if(queue.isEmpty()) {
            return null;
        }

        int[] result = new int[k+1];
        int index = 0;
        while(!queue.isEmpty() && index < k) {
            int number = queue.poll();
            result[number] = index;
            index++;

            for(int neighbor : graph[number]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(!queue.isEmpty()) {
            return null;
        }

        return result;
    }
}