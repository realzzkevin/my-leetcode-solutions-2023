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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        travelTree(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        return min;
    }

    public void travelTree(TreeNode node, List<Integer> list){
        if(node != null){
            travelTree(node.left, list);
            list.add(node.val);
            travelTree(node.right, list);
        }
    }
}