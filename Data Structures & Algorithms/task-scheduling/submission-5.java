class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxFrequency = freq[25];
        int idleSlots = (maxFrequency - 1) * n;
        for(int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(maxFrequency - 1, freq[i]);
        }

        return Math.max(0, idleSlots) + tasks.length;


    }
}
