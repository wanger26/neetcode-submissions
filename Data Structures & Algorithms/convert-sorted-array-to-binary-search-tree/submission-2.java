class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // Time: O(n)
        // Time: O(logn)
        return inorder(nums, 0, nums.length);
    }

    private TreeNode inorder(int[] nums, int index, int rightLimit) {
        if(index >= rightLimit) {
            return null;
        }

        int pivot = (rightLimit + index)/2;

        TreeNode node = new TreeNode(nums[pivot]);
        node.left = inorder(nums, index, pivot);
        node.right = inorder(nums, pivot+1, rightLimit);
        
        return node;
    }
}
