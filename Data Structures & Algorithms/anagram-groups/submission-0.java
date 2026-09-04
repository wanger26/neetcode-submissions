class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> charCountToWords = new HashMap<>();

        for(String string : strs) {
            Map<Character, Integer> charCount = new HashMap<>();
            for(char character : string.toCharArray()) {
                charCount.put(character, charCount.getOrDefault(character, 0) + 1);
            }

            charCountToWords.computeIfAbsent(charCount, k -> new ArrayList<>()).add(string);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> words : charCountToWords.values()) {
            result.add(words);
        }

        return result;
    }
}
