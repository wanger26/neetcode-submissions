class Solution {
    // Time: O(n*4^n)
    // Space: O(n)
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, List<Character>> digitsToCharacters = new HashMap<>();
        digitsToCharacters.put('2', List.of('a', 'b', 'c'));
        digitsToCharacters.put('3', List.of('d', 'e', 'f'));
        digitsToCharacters.put('4', List.of('g', 'h', 'i'));
        digitsToCharacters.put('5', List.of('j', 'k', 'l'));
        digitsToCharacters.put('6', List.of('m', 'n', 'o'));
        digitsToCharacters.put('7', List.of('p', 'q', 'r', 's'));
        digitsToCharacters.put('8', List.of('t', 'u', 'v'));
        digitsToCharacters.put('9', List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        result.add("");

        for(char digit : digits.toCharArray()) { // O(n)
            List<String> temp = new ArrayList<>();
            for(String currentResult : result) { //O(4^n)
                for(char character : digitsToCharacters.get(digit)) { // O(1)
                    temp.add(currentResult + character);
                }
            }
            result = temp;
        }

        return result;
    }
}
