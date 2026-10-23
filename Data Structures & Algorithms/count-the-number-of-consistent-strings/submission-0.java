class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = allowed.length();
        boolean[] allowedChars = new boolean[26];
        for(int i = 0; i < n; i++) {
            allowedChars[allowed.charAt(i) - 'a'] = true;
        }

        int result = 0;
        for(String word : words) {
            boolean consistent = true;
            for(int i = 0; i < word.length() && consistent; i++) {
                if(!allowedChars[word.charAt(i) - 'a']) {
                    consistent = false;
                }
            }

            if(consistent) {
                result++;
            }
        }

        return result;
    }
}