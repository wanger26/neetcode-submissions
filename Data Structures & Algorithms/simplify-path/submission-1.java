class Solution {
    public String simplifyPath(String path) {

        // Time: O(n)
        // Space: O(n)
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for(String current : paths) {
            if(current.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!current.equals("") && !current.equals(".")) {
                stack.push(current);
            }
        }

        return "/" + String.join("/", stack);
    }
}