class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Time: O(n)
        // Space: O(n)
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(mapping.containsKey(sChar)) {
                if(mapping.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if(mapped.contains(tChar)) {
                    return false;
                }
                mapping.put(sChar, tChar);
                mapped.add(tChar);
            }
        }

        return true;
    }
}