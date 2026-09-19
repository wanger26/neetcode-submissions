class Solution {

    public String reorganizeString(String s) {
        // Time: O(n)
        // Space: O(1)
        int maxIndex = 0;
        int[] characterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            characterCount[character - 'a']++;

            if(characterCount[character - 'a'] > characterCount[maxIndex]) {
                maxIndex = character - 'a';
            }
        }

        if (characterCount[maxIndex] > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];
        int index = 0;
        for (; index < result.length && characterCount[maxIndex] > 0; index=index+2) {
            result[index] = (char) (maxIndex + 'a');
            characterCount[maxIndex]--;
        }

        for (int i = 0; i < 26; i++) {
            while(characterCount[i] > 0) {
                if(index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                characterCount[i]--;

                index = index + 2;
            }
        }

        return new String(result);
    }
}