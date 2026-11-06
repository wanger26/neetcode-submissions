class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        /*
            Input: n = 3
            leftChild = [-1,-1,0]
            rightChild = [-1,-1,1]

            indegree[1,1,0]
        */
        int numOfEdges = 0;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for(int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if(left != -1) {
                indegree[left]++;
                outdegree[i]++;
                numOfEdges++;
            }

            if(right != -1) {
                indegree[right]++;
                outdegree[i]++;
                numOfEdges++;
            }

            if((left != -1 && indegree[left] >= 2) || (right != -1 && indegree[right] >= 2)) {
                return false;
            }
        }

        if(numOfEdges == n) {
            return false; // Cycle
        }

        int numOfRoots = 0;
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0 && outdegree[i] == 0) {
                return n == 1;
            } else if(indegree[i] == 0) {
                numOfRoots++;
            }

            if(numOfRoots > 1) {
                return false;
            }
        }

        return true;

    }
}
