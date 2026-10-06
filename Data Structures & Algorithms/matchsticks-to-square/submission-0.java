class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int matchStick : matchsticks) {
            sum += matchStick;
        }

        if(sum == 0 || sum % 4 != 0) {
            return false; 
        }

        int target = sum/4;
        return backtracking(matchsticks, 0, target, new int[4]);
    }

    private boolean backtracking(int[] matchsticks, int index, int target, int[] sides) {
        if(matchsticks.length == index) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int value = matchsticks[index];
        if(value > target) {
            return false;
        }

        boolean result = false;
        for(int i = 0; i < 4 && !result; i++) {

            if(sides[i] + value > target) {
                continue;
            }

            // Try using the matchstick for the given side
            sides[i] += value;
            result = backtracking(matchsticks, index + 1, target, sides);
            sides[i] -= value;
        }

        return result;
    }
}