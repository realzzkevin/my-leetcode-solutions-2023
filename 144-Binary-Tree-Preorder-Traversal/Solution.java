class Solution {
    //recursive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        if(root == null){
            return tree;
        }
        tree.add(root.val);
        nextNode(tree, root.left);
        nextNode(tree, root.right);
        return tree;
    }

    public void nextNode (List<Integer> tree, TreeNode node) {
        if(node == null) {
            return;
        }
        tree.add(node.val);
        nextNode(tree, node.left);
        nextNode(tree, node.right);
    }
}