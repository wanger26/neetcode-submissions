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
    public int minimumOperations(TreeNode root) {

        // Time: O(nlogw) where w is the width of the tree
        // Space: O(w) where w is the width of the tree
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);

        int result = 0;
        while(!level.isEmpty()) {
            int initalSize = level.size();
            int[] levelValues = new int[initalSize];
            for(int i = 0; i < initalSize; i++) {
                TreeNode current = level.poll();
                levelValues[i] = current.val;
                if(current.left != null) {
                    level.add(current.left);
                }

                if(current.right != null) {
                    level.add(current.right);
                }
            }

            int[] sortedValues = levelValues.clone();
            Arrays.sort(sortedValues);

            Map<Integer, Integer> valuesToIndex = new HashMap<>();
            for(int i = 0; i < initalSize; i++) {
                valuesToIndex.put(levelValues[i], i);
            }

            int numberOfSwaps = 0;
            for(int i = 0; i < initalSize; i++) {
                if(levelValues[i] == sortedValues[i]) {
                    continue;
                }

                result++;

                int swapIndex = valuesToIndex.get(sortedValues[i]);

                int currentValue = levelValues[i];
                levelValues[i] = sortedValues[i];
                levelValues[swapIndex] = currentValue;

                valuesToIndex.put(levelValues[i], i);
                valuesToIndex.put(currentValue, swapIndex);
            }
        }

        return result;
    }
}
