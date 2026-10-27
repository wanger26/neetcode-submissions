class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Time: O(n)
        // Space: O(n)
        int n = s.length();

        if(n < 10) {
            return new ArrayList<>();
        }

        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        StringBuilder bldr = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            bldr.append(currentChar);
            if(bldr.length() < 10) {
                continue;
            } else if(bldr.length() > 10) {
                bldr.deleteCharAt(0);
            }

            String currentDNA = bldr.toString();
            if(!seen.add(currentDNA)) {
                result.add(currentDNA);
            }
        }

        return new ArrayList<>(result);
    }
}
