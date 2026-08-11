class Solution {
    public boolean isHappy(int n) {

        int slowPointer = getNextNumber(n);
        int fastPointer = getNextNumber(getNextNumber(n));

        while(slowPointer != fastPointer && slowPointer != 1 && fastPointer != 1) {
            slowPointer = getNextNumber(slowPointer);
            fastPointer = getNextNumber(getNextNumber(fastPointer));
        }

        return slowPointer == 1 || fastPointer == 1;

    }

    private int getNextNumber(int currentNumber) {
        int nextNumber = 0;
        while (currentNumber > 0) {
            int digit = currentNumber % 10;
            nextNumber += digit * digit;
            currentNumber /= 10;
        }

        return nextNumber;
    }
}
