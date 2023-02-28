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
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    Node solve(int[][] grid, int x, int y, int length){
        if(length == 1) {
            return new Node((grid[x][y] == 1), true);
        } else {
            Node tf = solve(grid, x, y, length/2);
            Node tr = solve(grid, x, y + (length/2), length/2);
            Node bl = solve(grid, x+(length/2), y, length/2);
            Node br = solve(grid, x+(length/2), y+(length/2), length/2);

            if((tf.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && (tf.val == tr.val && bl.val == br.val && tf.val == bl.val))) {
                return new Node(tf.val, true);
            }

            return new Node(false, false, tf, tr, bl, br);
        }
    }
}
