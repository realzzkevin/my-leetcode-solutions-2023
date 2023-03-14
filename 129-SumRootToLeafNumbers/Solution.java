class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = sum(root, 0);
        return sum;
    }

    public int sum(TreeNode node, int num) {
        if(node == null) {
            return 0;
        } else {
            num = (num * 10) + node.val;
            int sums = 0;
            if(node.left != null){
                sums += sum(node.left, num);
            }
            if(node.right != null) {
                sums += sum(node.right, num);
            }

            return sums == 0 ? num : sums;
        }
    }
}