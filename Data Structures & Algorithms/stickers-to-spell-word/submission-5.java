class Solution {
    public int minStickers(String[] stickers, String target) {

        // Time: O(2^t * s * t)
        // Space: O(t*2^t)
        int[] targetArray = toFreqCountArray(target);

        int[] allChars = new int[26];
        for (String sticker : stickers) {
            for (int i = 0; i < sticker.length(); i++) {
                allChars[sticker.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (targetArray[i] > 0 && allChars[i] == 0) {
                return -1;
            }
        }

        return dp(stickers, target, new HashMap<>());
    }

    private int dp(String[] stickers, String target, Map<String, Integer> memo) {
        if (target.isEmpty()) {
            return 0;
        } else if(memo.containsKey(target)) {
            return memo.get(target);
        }

        int result = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            int numOfChanges = 0;
            int[] stickerFreqArray = toFreqCountArray(sticker);
            StringBuilder bldr = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                char targetChar = target.charAt(i);
                if(stickerFreqArray[targetChar-'a'] > 0) {
                    numOfChanges++;
                    stickerFreqArray[targetChar - 'a']--;
                } else {
                    bldr.append(targetChar);
                }
            }

            if(numOfChanges > 0) {
                result = Math.min(result, 1 + dp(stickers, bldr.toString(), memo));
            }
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
