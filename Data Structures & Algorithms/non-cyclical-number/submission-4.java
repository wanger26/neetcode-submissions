class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        int currentNumber = n;
        while(!seen.contains(currentNumber) && currentNumber != 1) {
            seen.add(currentNumber);
            int sum = 0;
            while(currentNumber/10 > 0) {
                System.out.println(currentNumber);
                int digit = currentNumber % 10;
                currentNumber = currentNumber / 10;

                sum += digit*digit;
            }
            sum += currentNumber*currentNumber;
            currentNumber = sum;
        }

        return currentNumber == 1;
        
    }
}
