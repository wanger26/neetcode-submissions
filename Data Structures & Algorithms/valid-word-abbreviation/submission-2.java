class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        // Time: O(a)
        // Space: O(1)
        if(word.length() < abbr.length()) {
            return false;
        }

        int wordIndex = 0;
        int abbrIndex = 0;
        while(wordIndex < word.length() && abbrIndex < abbr.length()) {
            if(Character.isDigit(abbr.charAt(abbrIndex)) && abbr.charAt(abbrIndex) != '0') {
                int value = abbr.charAt(abbrIndex++) - '0';
                while(abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    value = value * 10 + abbr.charAt(abbrIndex++) - '0';
                }
                wordIndex += value;
            } else {
                if(word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}