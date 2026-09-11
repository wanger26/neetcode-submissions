class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int maxFrequency = count[25];
        
        int idleSlots = (maxFrequency-1) * n;
        for(int i=24; i >= 0; i--) {
            idleSlots -= Math.min(maxFrequency-1, count[i]);
        }

        return Math.max(0, idleSlots) + tasks.length;
    }
}
