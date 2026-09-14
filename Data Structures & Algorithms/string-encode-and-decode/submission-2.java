class Solution {

    // Time: O(n)
    public String encode(List<String> strs) {

        if(strs == null) {
            return null;
        }

        StringBuilder bldr = new StringBuilder();
        for(String str : strs) {
            bldr.append(str.length()).append("#");
        }

        if(strs.isEmpty()) {
            bldr.append("#");        
        }
        bldr.append("#");

        for(String str : strs) {
            bldr.append(str);
        }

        return bldr.toString();
    }

    // Time: O(n)
    public List<String> decode(String str) {
        System.out.println(str);
        if(str == null) {
            return null;
        }

        int sizeIndex = 0;
        int sizeIndexEnd = 0;
        while(str.charAt(sizeIndexEnd) != '#' || str.charAt(sizeIndexEnd+1) != '#') {
            sizeIndexEnd++;
        }

        int wordIndex = sizeIndexEnd+2;
        List<String> result = new ArrayList<>();
        while(sizeIndex < sizeIndexEnd) {
            StringBuilder lengthBldr = new StringBuilder();
            while(str.charAt(sizeIndex) != '#') {
                lengthBldr.append(str.charAt(sizeIndex));
                sizeIndex++;
            }
            sizeIndex++; // Skip trailing #

            int length = Integer.parseInt(lengthBldr.toString());
            result.add(str.substring(wordIndex, wordIndex + length));
            wordIndex += length;
        }

        return result;

    }
}
