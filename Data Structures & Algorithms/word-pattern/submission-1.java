class Solution {
    public boolean wordPattern(String pattern, String s) {
        Set<String> mapped = new HashSet<>();
        Map<Character, String> patternSymbolToWord = new HashMap<>();
        String[] words = s.split(" ");

        if(words.length != pattern.length()) {
            return false;
        }

        for(int i = 0; i < words.length; i++) {
            char symbol = pattern.charAt(i);

            if(patternSymbolToWord.containsKey(symbol)) {
                if(!patternSymbolToWord.get(symbol).equals(words[i])) {
                    return false;
                }
            } else {
                if(!mapped.add(words[i])) {
                    return false;
                }
                patternSymbolToWord.put(symbol, words[i]);
            }
        }

        return true;
    }
}