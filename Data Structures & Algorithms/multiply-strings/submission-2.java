class Solution {

    // Time: O(m*n)
    // Space: O(m*n)
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];
        for(int i=num1.length() - 1; i >= 0; i--) {
            for(int j=num2.length()-1; j >= 0; j--) {
                int num1Int = num1.charAt(i) - '0';
                int num2Int = num2.charAt(j) - '0';

                int currentindex = i+j+1;
                int carryIndex = i+j;
    
                int product = num1Int * num2Int + result[currentindex];
                int carry = product/10;

                result[currentindex] = product%10;
                result[carryIndex] += carry;
            }
        }

        String resultString = "";
        int index = 0;
        while(result[index] == 0) {
            index++;
        }

        for(; index < result.length; index++) {
            resultString =  resultString + result[index];
        }

        return resultString;
    }

}
