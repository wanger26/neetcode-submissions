class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for(int bill : bills) {
            if(bill == 5) {
                fives++;
            } else if (bill == 10) {
                if(fives == 0) {
                    return false;
                }
                fives--;
                tens++;
            } else {
                int changeNeeded = 15;
                if(tens > 0) {
                    changeNeeded -= 10;
                    tens--;
                }

                if(changeNeeded/5 > fives) {
                    return false;
                }
                fives -= changeNeeded/5;
            }
        }

        return true;
    }
}