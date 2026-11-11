class Solution {
    public long dividePlayers(int[] skill) {

        // Time: O(nlogn)
        // Space: O(logn)
        int n = skill.length;

        if(n % 2 != 0) {
            return -1L;
        }

        Arrays.sort(skill);

        int prevSum = skill[0] + skill[n-1];
        long result = skill[0] * skill[n-1];
        for(int i = 1; i < n/2; i++) {
            int sum = skill[i] + skill[n-i-1];
            if(sum != prevSum) {
                return -1L;
            }
            result += skill[i] * skill[n-i-1];
        }

        return result;
    }
}
