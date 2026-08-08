class Solution {

    private List<String> part = new ArrayList<>();
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        findPartions(s, 0, 0);
        return result;
    }

    private void findPartions(String s, int leftIndex, int rightIndex) {
        if(s.length() == rightIndex) {
            // Only add to result if we are not actively trying to finish a palindrom (when left == right). Otherwise we come from 2nd recursive call which is looking for a palindrome
            if(leftIndex == rightIndex) {
                result.add(new ArrayList<>(part)); // Make copy since we remove things in parent call
            }
            return;
        }

        // Option 1: Current string is palindrom. Use it and go further
        if(isPalindrome(s, leftIndex, rightIndex)) {
            part.add(s.substring(leftIndex, rightIndex+1));
            findPartions(s, rightIndex+1, rightIndex+1);
            // Undo our work to give Option 2 clean state
            part.remove(part.size()-1);
        }
        // Option 2: Go deeper instead of using current string
        findPartions(s, leftIndex, rightIndex+1);
    }

    private boolean isPalindrome(String s, int leftIndex, int rightIndex) {
        while(leftIndex < rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
