class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        } else {
            return Math.max(DSF(root.left, 1), DSF(root.right, 1));
        }
    }

    public int DSF(TreeNode node, int high){
        if(node == null){
            return high;
        } else {
            high++;
            return Math.max(DSF(node.left, high), DSF(node.right, high));
        }
    }

}