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
    private List<Long> sumsList;

    private void levelSums( TreeNode node, List<Long> list, int level) {
        if(node != null) {
            if(list.size() <= level) {
                list.add((long) 0);
            }
            list.set(level, list.get(level) + node.val);
            levelSums(node.left, list, level+1);
            levelSums(node.right, list, level+1);

        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        sumsList = new ArrayList<Long>();
        levelSums(root, sumsList, 0);

        if(sumsList.size() < k) {
            return -1;
        }
        Collections.sort(sumsList, Collections.reverseOrder());


        return sumsList.get(k-1);
    }
}