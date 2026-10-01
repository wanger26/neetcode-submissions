class Solution {
    public int findJudge(int n, int[][] trust) {

        // Time: O(v+e) where v is the number of people, and e is the number of trust
        // Space: O(v)
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] trustRelation : trust) {
            int trustor = trustRelation[0];
            int trusted = trustRelation[1];

            indegree[trusted - 1]++;
            outdegree[trustor - 1]++;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}