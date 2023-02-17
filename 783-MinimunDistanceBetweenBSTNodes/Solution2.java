class Solution {
    int min;
    TreeNode prevVal;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        travelTree(root);
        return min;
    }

    public void travelTree(TreeNode node){
        if(node != null) {
            travelTree(node.left);
            if(prevVal != null){
                min = Math.min(min, Math.abs(node.val - prevVal.val));
            }
            prevVal = node;
            travelTree(node.right);
        }

    }
}