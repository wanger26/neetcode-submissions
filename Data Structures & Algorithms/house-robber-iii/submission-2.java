/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {

        // Time: O(n)
        // Space: O(n)
        Map<String, Integer> memo = new HashMap<>();
        return dp(root, true, memo);
    }

    private int dp(TreeNode currentNode, boolean canrob, Map<String, Integer> memo) {
        String key = currentNode + "," + canrob;

        if(currentNode == null) {
            return 0;
        } else if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;
        // Option 1: If can rob. Rob
        if(canrob) {
            result = dp(currentNode.left, false, memo) + dp(currentNode.right, false, memo) + currentNode.val;
        }

        // Option 2: do not rob. So we can rob next house
        result = Math.max(result, dp(currentNode.left, true, memo) + dp(currentNode.right, true, memo));

        memo.put(key, result);
        return result;
    }
}