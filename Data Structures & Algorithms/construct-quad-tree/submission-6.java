/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        // Time: O(n^2)
        // Space: O(log(n))
        return construct(grid, 0, grid.length, 0, grid[0].length);
    }

    public Node construct(int[][] grid, int leftBoundry, int rightBoundry, int topBoundry, int bottomBoundry) {
        if (rightBoundry - leftBoundry == 1) {
            return new Node(grid[topBoundry][leftBoundry] == 1, true);
        }

        int horizontalSplit = leftBoundry + (rightBoundry - leftBoundry) / 2;
        int verticalSplit = topBoundry + (bottomBoundry - topBoundry) / 2;

        // Recurse FIRST (Bottom-Up)
        Node topLeft = construct(grid, leftBoundry, horizontalSplit, topBoundry, verticalSplit);
        Node topRight = construct(grid, horizontalSplit, rightBoundry, topBoundry, verticalSplit);
        Node bottomLeft = construct(grid, leftBoundry, horizontalSplit, verticalSplit, bottomBoundry);
        Node bottomRight = construct(grid, horizontalSplit, rightBoundry, verticalSplit, bottomBoundry);

        // Check if we can merge the 4 children into a single leaf
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            
            // Merge them into one leaf node, discard the children
            return new Node(topLeft.val, true);
        }

        // If we cannot merge, return this as an internal node
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}