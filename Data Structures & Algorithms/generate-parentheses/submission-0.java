class Solution {

    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParenthesis(n, n, "");
        return result;
    }

    private void generateParenthesis(int opening, int closing, String current) {
        if(opening == 0 && closing == 0) {
            this.result.add(new String(current));
        }

        // Option 1: Add another (
        if(opening > 0) {
            generateParenthesis(opening-1, closing, current + '(');
        }

        // Option 2: If opening is less than closing, we can add a closing and keep it valid
        if(opening < closing) {
            generateParenthesis(opening, closing-1, current + ')');
        }

    }
}
