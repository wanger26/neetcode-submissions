class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        // Time: O(m + n)
        // Space: O(1)
        if(!(str1 + str2).equals(str2+str1)) {
            return "";
        }

        int num1 = str1.length();
        int num2 = str2.length();
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        int gcdLength = num1;

        return str1.substring(0, gcdLength);
    }
}