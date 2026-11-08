class Solution {
    public String[] wordSubsets(String[] words1, String[] words2) {
        int[] minFreqCount = new int[26];

        for (String word : words2) {
            int[] freqCount = getFreqCount(word);
            for (int i = 0; i < 26; i++) {
                minFreqCount[i] = Math.max(minFreqCount[i], freqCount[i]);
            }
        }

        List<String> resultList = new ArrayList<>();
        for (String word : words1) {
            int[] freqCount = getFreqCount(word);
            boolean isValid = true;
            for(int i = 0; i < 26 && isValid; i++) {
                if(minFreqCount[i] > freqCount[i]) {
                    isValid = false;
                }
            }

            if(isValid) {
                resultList.add(word);
            }
        }

        String[] result = new String[resultList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private int[] getFreqCount(String word) {
        int[] freqCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freqCount[word.charAt(i) - 'a']++;
        }

        return freqCount;
    }
}
