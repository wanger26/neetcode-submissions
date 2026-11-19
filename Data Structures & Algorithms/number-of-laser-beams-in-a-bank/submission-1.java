class Solution {
    public int numberOfBeams(String[] bank) {

        // Time: O(n*m)
        // Space: O(1)

        int n = bank.length;

        int result = 0;
        int prevRowDevices = 0;
        for(int i = 0; i < n; i++) {
            int numberOfDevices = 0;
            for(int j = 0; j < bank[0].length(); j++) {
                if(bank[i].charAt(j) == '1') {
                    numberOfDevices++;
                }
            }
            result += prevRowDevices * numberOfDevices;
            prevRowDevices = numberOfDevices == 0 ? prevRowDevices : numberOfDevices;
        }

        return result;
    }
}
