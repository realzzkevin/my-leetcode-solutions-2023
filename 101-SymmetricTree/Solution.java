class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);

    }

    public boolean isMirror(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        } else if(n1 == null || n2 == null ) {
            return false;
        }

        return (n1.val == n2.val) && isMirror(n1.left, n2.right) &&
                isMirror(n1.right, n2.left);


    }

}