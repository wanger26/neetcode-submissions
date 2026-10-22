class Solution {
    public int minStickers(String[] stickers, String target) {

        // Time: O(L + M * s * t)
        // Space: O(M * t + s)
        int[] targetFreq = toFreqCountArray(target);
        int[][] stickerFreqs = new int[stickers.length][26];
        int[] allChars = new int[26];

        for (int i = 0; i < stickers.length; i++) {
            stickerFreqs[i] = toFreqCountArray(stickers[i]);

            for (int j = 0; j < 26; j++) {
                allChars[j] += stickerFreqs[i][j];
            }
        }

        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] > 0 && allChars[i] == 0) {
                return -1;
            }
        }

        return dp(stickerFreqs, target, new HashMap<>());
    }

    private int dp(
            int[][] stickerFreqs,
            String target,
            Map<String, Integer> memo) {

        if (target.isEmpty()) {
            return 0;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int result = Integer.MAX_VALUE;
        int firstChar = target.charAt(0) - 'a';

        for (int[] stickerFreq : stickerFreqs) {

            // Skip stickers that cannot help with the first character.
            if (stickerFreq[firstChar] == 0) {
                continue;
            }

            int[] remainingStickerFreq = stickerFreq.clone();
            StringBuilder remainingTarget = new StringBuilder();

            for (int i = 0; i < target.length(); i++) {
                int charIndex = target.charAt(i) - 'a';

                if (remainingStickerFreq[charIndex] > 0) {
                    remainingStickerFreq[charIndex]--;
                } else {
                    remainingTarget.append(target.charAt(i));
                }
            }

            int subResult = dp(
                stickerFreqs,
                remainingTarget.toString(),
                memo
            );

            result = Math.min(result, 1 + subResult);
        }

        memo.put(target, result);
        return result;
    }

    private int[] toFreqCountArray(String s) {
        int[] freqArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i) - 'a']++;
        }

        return freqArray;
    }
}