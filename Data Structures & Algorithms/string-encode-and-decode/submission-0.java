class Solution {

    //_length#_length_#__##
    public String encode(List<String> strs) {

        if(strs == null) {
            return null;
        }

        StringBuilder bldr = new StringBuilder();
        for(String str : strs) {
            bldr.append(str.length()).append("#");
        }

        if(strs.size() == 0) {
            bldr.append("#");        
        }
        bldr.append("#");

        for(String str : strs) {
            bldr.append(str);
        }

        return bldr.toString();
    }

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

            int length = Integer.valueOf(lengthBldr.toString());
            StringBuilder bldr = new StringBuilder();
            for(int i=0; i < length; i++) {
                bldr.append(str.charAt(wordIndex));
                wordIndex++;
            }
            result.add(bldr.toString());
        }

        return result;

    }
}
