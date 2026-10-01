class Solution {
    public int findJudge(int n, int[][] trust) {

        // Time: O(v+e) where v is the number of people, and e is the number of trust
        // Space: O(v)
        int[] diff = new int[n];

        for(int[] trustRelation : trust) {
            int trustor = trustRelation[0];
            int trusted = trustRelation[1];

            diff[trustor - 1]--;
            diff[trusted - 1]++;
        }

        int count = 0;
        int judge = -1;
        for(int i = 0; i < n; i++) {
            if(diff[i] == n-1) {
                return i + 1;
            }
        }

        return -1;
    }
}