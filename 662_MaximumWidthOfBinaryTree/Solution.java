class solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWitdth = 0;
        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0){
            Pair<TreeNode, Integer> head = queue.getFirst();
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for(int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if(node.left != null) {
                    queue.addLast(new Pair<>(node.left, 2* elem.getValue()));
                }
                if(node.right != null){
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue()) + 1);
                }
            }

            maxWitdth = Math.max(maxWitdth, elem.getValue() - head.getValue() +1);
        }

        return maxWitdth;
    }
}