class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char character : s.toCharArray()) {
            sMap.put(character, sMap.getOrDefault(character, 0) + 1);
        }

        for(char character : t.toCharArray()) {
            tMap.put(character, tMap.getOrDefault(character, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
