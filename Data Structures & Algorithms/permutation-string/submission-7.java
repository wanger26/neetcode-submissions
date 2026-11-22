class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int[] window = new int[26];
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char character = s2.charAt(right);
            if (s1Freq[character - 'a'] == 0) {
                Arrays.fill(window, 0);
                left = right + 1;
                continue;
            }
            window[character - 'a']++;

            if (s1Freq[character - 'a'] == window[character - 'a']) {
                boolean found = true;
                for(int i = 0; i < 26 && found; i++) {
                    if(window[i] != s1Freq[i]) {
                        found = false;
                    }
                }

                if(found) {
                    return true;
                }

            } else if (s1Freq[character - 'a'] < window[character - 'a']) {
                while (s1Freq[character - 'a'] < window[character - 'a']) {
                    window[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
        }
        return false;
    }
}
