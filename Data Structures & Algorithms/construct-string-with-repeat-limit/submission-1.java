class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                int count = Math.min(freq[i], repeatLimit);

                for (int j = 0; j < count; j++) {
                    result.append((char) ('a' + i));
                }

                freq[i] -= count;

                if (freq[i] > 0) {
                    int next = i - 1;

                    while (next >= 0 && freq[next] == 0) {
                        next--;
                    }

                    if (next < 0) {
                        return result.toString();
                    }

                    result.append((char) ('a' + next));
                    freq[next]--;
                }
            }
        }

        return result.toString();
    }
}