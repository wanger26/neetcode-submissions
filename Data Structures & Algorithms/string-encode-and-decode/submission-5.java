class Solution {

    // __#


    public String encode(List<String> strs) {
        StringBuilder bldr = new StringBuilder();
        for(String str : strs) {
            bldr.append(str.length());
            bldr.append("#");
            bldr.append(str);
        }
        return bldr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            StringBuilder bldr = new StringBuilder();
            while(str.charAt(index) != '#') {
                bldr.append(str.charAt(index));
                index++;
            }
            int size = Integer.parseInt(bldr.toString());
            index++;

            bldr = new StringBuilder();
            for(int i = 0; i < size; i++) {
                bldr.append(str.charAt(index));
                index++;
            }
            result.add(bldr.toString());
        }

        return result;
    }
}
