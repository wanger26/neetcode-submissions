/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Time: O(logn)
        // Space: O(1)

        int left = 0;
        int right = n;

        while(left <= right) {
            int nextGuess = (int)(((long)left+right)/2L);
            int result = guess(nextGuess);

            if(result == 0) {
                return nextGuess;
            } else if (result < 0) {
                right = nextGuess - 1;
            } else {
                left = nextGuess + 1;
            }
        }

        return -1;
    }
}