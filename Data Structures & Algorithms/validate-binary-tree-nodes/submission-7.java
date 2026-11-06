class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // Time: O(n)
        // Space: O(n)

        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if(left != -1) {
                indegree[left]++;
            }

            if(right != -1) {
                indegree[right]++;
            }

            if((left != -1 && indegree[left] >= 2) ||
               (right != -1 && indegree[right] >= 2)) {
                return false;
            }
        }

        int root = -1;
        int numOfRoots = 0;

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                root = i;
                numOfRoots++;
            }

            if(numOfRoots > 1) {
                return false;
            }
        }

        // Must have exactly one root.
        if(root == -1) {
            return false;
        }

        boolean[] seen = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == -1) {
                continue;
            } else if (seen[node]) {
                return false;
            }

            seen[node] = true;
            queue.add(leftChild[node]);
            queue.add(rightChild[node]);
        }

        // Every node must be reachable from the root.
        for(boolean visited : seen) {
            if(!visited) {
                return false;
            }
        }

        return true;
    }
}