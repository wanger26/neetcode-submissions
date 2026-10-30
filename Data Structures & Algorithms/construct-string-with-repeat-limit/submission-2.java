class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            while (frequency[i] > 0) {
                int count = Math.min(frequency[i], repeatLimit);

                for (int j = 0; j < count; j++) {
                    result.append((char) ('a' + i));
                }

                frequency[i] -= count;

                if (frequency[i] > 0) {
                    int next = i - 1;

                    while (next >= 0 && frequency[next] == 0) {
                        next--;
                    }

                    if (next < 0) {
                        return result.toString();
                    }

                    result.append((char) ('a' + next));
                    frequency[next]--;
                }
            }
        }

        return result.toString();
    }
}