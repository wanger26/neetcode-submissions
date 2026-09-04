class Solution {
    // Time: O(n * c)
    // Space: O(n * c)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. Create a frequency array for the word
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // 2. Convert array to a String to use as a map key
            // E.g. "[1, 0, 0, 1, ...]"
            String key = Arrays.toString(count);
            
            // 3. Add the string to the correct group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Return the grouped values
        return new ArrayList<>(map.values());
    }
}