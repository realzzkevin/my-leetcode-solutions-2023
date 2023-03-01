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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        travelTree(root, new HashMap<String, Integer>(), list);
        return list;
    }

    public String travelTree (TreeNode node, Map<String, Integer> map, List<TreeNode> list){
        String str = "";
        if(node != null) {
            str = "(" + travelTree(node.left, map, list) + ")" + node.val + "(" + travelTree(node.right, map, list) +")";
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str)==2){
                list.add(node);
            }
        }
        return str;
    }
}