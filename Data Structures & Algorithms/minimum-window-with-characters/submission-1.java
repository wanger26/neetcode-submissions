class Solution {
    // OUZODYXAZV
    //      |     -> 4. Valid answer. Note, advance left to first char in t
    //      |  | -> 3
    //        |  // Once we get to end once. Done
    public String minWindow(String s, String t) {
        String result = "";

        Map<Character, Integer> tCharFreqCount = charFreqCount(t);
        Set<Character> found = new HashSet<>();
        Map<Character, Integer> windowCharFreqCount = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char character = s.charAt(right);

            // If character is not in t we can skip it.
            if (!tCharFreqCount.containsKey(character)) {
                right++;
                continue;
            }

            windowCharFreqCount.put(character, windowCharFreqCount.getOrDefault(character, 0) + 1);
            if (windowCharFreqCount.get(character).equals(tCharFreqCount.get(character))) {
                found.add(character);
            }

            // If we have found all t in S. We have an answer. Now keep shrinking until we no longer
            // have an answer
            while (found.size() == tCharFreqCount.size()) {
                // Move over all skipped chars
                while (left <= right && !tCharFreqCount.containsKey(s.charAt(left))) {
                    left++;
                }

                if (result.equals("") || right - left + 1 < result.length()) {
                    result = s.substring(left, right + 1);
                }

                char leftCharacter = s.charAt(left);
                windowCharFreqCount.put(leftCharacter, windowCharFreqCount.get(leftCharacter) - 1);
                if (windowCharFreqCount.get(leftCharacter) < tCharFreqCount.get(leftCharacter)) {
                    found.remove(leftCharacter);
                }
                left++;
            }

            right++;
        }

        return result;
    }

    private Map<Character, Integer> charFreqCount(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char character : string.toCharArray()) {
            result.put(character, result.getOrDefault(character, 0) + 1);
        }
        return result;
    }
}
