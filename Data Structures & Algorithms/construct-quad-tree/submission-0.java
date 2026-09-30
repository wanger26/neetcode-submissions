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
// [1,1,1,1,0,0,0,0]
// [1,1,1,1,0,0,0,0]
// [1,1,1,1,1,1,1,1]
// [1,1,1,1,1,1,1,1]
// [1,1,1,1,0,0,0,0]
// [1,1,1,1,0,0,0,0]
// [1,1,1,1,0,0,0,0]
// [1,1,1,1,0,0,0,0]

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length, 0, grid[0].length);
    }

    public Node construct(int[][] grid, int leftBoundry, int rightBoundry, int topBoundry, int bottomBoundry) {
        Node newNode = new Node();
        boolean isLeaf = true;
        int value = grid[topBoundry][leftBoundry];
        for(int y = topBoundry; y < bottomBoundry && isLeaf; y++) {
            for(int x = leftBoundry; x < rightBoundry && isLeaf; x++) {
                if(value != grid[y][x]) {
                    isLeaf = false;
                }
            }
        }

        newNode.isLeaf = isLeaf;

        if(isLeaf) {
            newNode.val = value == 1;
        } else {
            int horizontalSplit = leftBoundry + (rightBoundry - leftBoundry) / 2;
            int verticalSplit = topBoundry + (bottomBoundry - topBoundry) / 2;

            newNode.topLeft = construct(grid, leftBoundry, horizontalSplit, topBoundry, verticalSplit);
            newNode.topRight = construct(grid, horizontalSplit, rightBoundry, topBoundry, verticalSplit);;
            newNode.bottomLeft = construct(grid, leftBoundry, horizontalSplit, verticalSplit, bottomBoundry);
            newNode.bottomRight = construct(grid, horizontalSplit, rightBoundry, verticalSplit , bottomBoundry);
        }

        return newNode;
    }
}