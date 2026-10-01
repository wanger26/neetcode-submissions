class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] trustRelation : trust) {
            int trustor = trustRelation[0];
            int trusted = trustRelation[1];

            indegree[trusted - 1]++;
            outdegree[trustor - 1]++;
        }

        int count = 0;
        int judge = -1;
        for(int i = 0; i < n; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0) {
                count++;
                judge = i + 1;
            }
        }

        return count == 1 ? judge : -1;
    }
}