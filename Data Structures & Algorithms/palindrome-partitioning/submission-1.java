class Solution {

    private List<List<String>> result = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return result;
    }

    private void dfs(int startIndex, int endIndex, String s) {

        if(endIndex == s.length()) {
            if (startIndex == endIndex) {
                result.add(new ArrayList<>(part));
            }
            return;
        }

        if(isPalindrom(s, startIndex, endIndex)) {
            part.add(s.substring(startIndex, endIndex+1));
            dfs(endIndex+1, endIndex + 1, s);
            part.remove(part.size()-1);
        }
        dfs(startIndex, endIndex+1, s);
    }

    private boolean isPalindrom(String string, int leftIndex, int rightIndex) {

        while(leftIndex < rightIndex) {
            if(string.charAt(leftIndex) != string.charAt(rightIndex)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
