
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        LinkedList<Integer> level = new LinkedList<Integer>();
        boolean isOrderLeft = true;

        while (nodeQueue.size()> 0) {
            TreeNode curr = nodeQueue.pollFirst();
            if(curr != null) {
                if(isOrderLeft){
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }

                if(curr.left != null){
                    nodeQueue.addLast(curr.left);
                }
                if(curr.right != null) {
                    nodeQueue.addLast(curr.right);
                }
            } else {
                results.add(level);
                level = new LinkedList<Integer>();
                if(nodeQueue.size() > 0) {
                    nodeQueue.addLast(null);
                }
                isOrderLeft = !isOrderLeft;
            }
        }

        return results;
    }
}