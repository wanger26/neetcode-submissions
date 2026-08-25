
// Time: O(m*n)
// Space: O(k) or O(1) --> Since max is 26*2=52

// Where n is size of s, m is size of t, and k is unique strings
class Solution {
    // OUZODYXAZV
    //      |     -> 4. Valid answer. Note, advance left to first char in t
    //      |  | -> 3
    //        |  // Once we get to end once. Done
    public String minWindow(String s, String t) {
        int resultStartingIndex = 0;
        int resultLength = 0;

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

                if (resultLength == 0 || right - left + 1 < resultLength) {
                    resultStartingIndex = left;
                    resultLength = right - left + 1;
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

        return s.substring(resultStartingIndex, resultStartingIndex+resultLength);
    }

    private Map<Character, Integer> charFreqCount(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char character : string.toCharArray()) {
            result.put(character, result.getOrDefault(character, 0) + 1);
        }
        return result;
    }
}
