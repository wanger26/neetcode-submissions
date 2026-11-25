class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int[] frequencyArray = new int[26];
            for (int i = 0; i < str.length(); i++) {
                frequencyArray[str.charAt(i) - 'a']++;
            }

            StringBuilder bldr = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                bldr.append(frequencyArray[i]);
                bldr.append(",");
            }

            String key = bldr.toString();
            if(!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> strings : anagrams.values()) {
            result.add(strings);
        }

        return result;
    }
}
